function res = simulate(t, l, init)
    res = zeros(max(t)-min(t)+1, max(size(init))+3);
    res(1, :) = [t(1, 1), init', sum(init), 0];
    pSum = sum(init);
    
    for i = min(t)+1:max(t)
        init = l*init;
        change = ((sum(init)-pSum)/pSum)*100;
        res(i-(t(1, 1) - 1), :) = [i, init', sum(init), change];
        pSum = sum(init);
    end
end