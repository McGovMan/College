function [d, s_r, s_c] = Conversions()
% This function returns handles to sum_r, sum_c and diag. 
% sum_r returns the sum of all the rows in a matrix into a 
% column at the end.
% sum_c returns the sum of all the columns in a matrix into a
% row at the bottom.
% diag returns the row of a diagonal in a matrix and returns it as a row.

s_r = @sum_r;
s_c = @sum_c;
d = @diag_row;
end

function [B] = sum_r(M)
    B = [M sum(M,2)];
end

function [A] = sum_c(M)
    A = [M;sum(M)];
end

function [C] = diag_row(M)
    A = diag(M);
    C = A.';
end