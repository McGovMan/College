function [O, c] = shuffle_pic(I)    picSize = size(I);    O = zeros(picSize);        # Generating borders for image in matrix with left most column holding row number    c = [1 1 floor(picSize(1, 1)/2) 1 floor(picSize(1, 2)/2);2 1 floor(picSize(1, 1)/2) (floor(picSize(1, 2)/2))+1 picSize(1, 1);3 (floor(picSize(1, 1)/2))+1 picSize(1, 1) 1 floor(picSize(1, 2)/2);4 (floor(picSize(1, 1)/2))+1 picSize(1, 1) (floor(picSize(1, 2)/2))+1 picSize(1, 2)];        x = randstream(1:4);    # Adding randomised column to right of matrix    c = [c x'];        # Generating image based on columns on right of matrix.    for i = 1:4        currRow = c(c(:,6) == i);        O(c(currRow, 2):c(currRow, 3), c(currRow, 4):c(currRow, 5)) = I(c(i, 2):c(i, 3), c(i, 4):c(i, 5));    end    O = uint8(O);end