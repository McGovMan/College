I = imread('cameraman.tif');

#rng(100);
[O,c] = shuffle_pic(I);

subplot(1,2,1);
imshow(I);
title('Original');
subplot(1,2,2);
imshow(O);
title('Shuffled');

disp(["The inner matrix for shuffling the picture is as follows"]);
disp(c);