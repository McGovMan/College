rng(100);
A = randi([0 1], 20,10);
A1 = [A;sum(A)];
A2 = [A sum(A,2)];
[valA1, indexA1] = max(A1(21, :));
[valA2, indexA2] = max(A2(:, 11));
disp(['The index for the product with the most sales is ', num2str(indexA1), ' with a value ', num2str(valA1)]);
disp(['The index for the product with the most sales is ', num2str(indexA2), ' with a value ', num2str(valA2)]);