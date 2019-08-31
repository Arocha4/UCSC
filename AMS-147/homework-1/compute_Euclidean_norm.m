%antoine rocha
%arocha4@ucsc.edu
% Edclidean_norm
%output : norm of the vectoriz
%input : vectoriz
function [z] = compute_Euclidean_norm (x) % given though problem
  z= 0;
  % sumation of the squares of vectors
  for i =1:length(x) % legth(x)
    z = z+x(i).^2;
  end
  %square root of the summation check the problem to see why its the formula given
  z = z.^(0.5);
  end

end
