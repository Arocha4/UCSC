# Lab 3 Skeleton
# antoine Rocha
#arocha4@ucsc.edu
# Based on of_tutorial by James McCauley

from pox.core import core
import pox.openflow.libopenflow_01 as of

import pox.lib.packet as pkt

log = core.getLogger()

class Firewall (object):
  """
  A Firewall object is created for each switch that connects.
  A Connection object for that switch is passed to the __init__ function.
  """
  def __init__ (self, connection):
    # Keep track of the connection to the switch so that we can
    # send it messages!
    self.connection = connection

    # This binds our PacketIn event listener
    connection.addListeners(self)

  def do_firewall (self, packet, packet_in):
    # The code in here will be executed for every packet.
    # print "Example Code."
	msg = of.ofp_flow_mod()
	msg.match = of.ofp_match.from_packet(packet)
	msg.idle_timeout = 40 #timeout set
	msg.hard_timeout = 80 #hardtimeout set
	IP = packet.find('ipv4') #ipv4 protocol only
	
	if IP is None:  # if not IP
		msg.data = packet_in # set data packet_in
		ARP = packet.find('arp') #search for ARP
		if ARP is None: 
			msg.data = packet_in
			self.connection.send(msg)
		else: 
			msg.data = packet_in
			msg.match.dl_type = 0x0806 # ARP classifier field
			action = of.ofp_action_output(port = of.OFPP_ALL)
			msg.actions.append(action)
			self.connection.send(msg)
	else:
		ICMP = packet.find('icmp') #if field is icmp
		if ICMP is None:  
			msg.data = packet_in
			self.connection.send(msg)
		else:
			msg.data = packet_in
			msg.new_proto = 1 #protocaol for icmp
			action = of.ofp_action_output(port = of.OFPP_ALL)
			msg.actions.append(action) 
			self.connection.send(msg)
		
		

  def _handle_PacketIn (self, event):
    """
    Handles packet in messages from the switch.
    """

    packet = event.parsed # This is the parsed packet data.
    if not packet.parsed:
      log.warning("Ignoring incomplete packet")
      return

    packet_in = event.ofp # The actual ofp_packet_in message.
    self.do_firewall(packet, packet_in)

def launch ():
  """
  Starts the component
  """
  def start_switch (event):
    log.debug("Controlling %s" % (event.connection,))
    Firewall(event.connection)
  core.openflow.addListenerByName("ConnectionUp", start_switch)
