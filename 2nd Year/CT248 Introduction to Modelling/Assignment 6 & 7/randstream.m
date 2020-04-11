function ans = randstream(x)
    ans = x(randperm(length(x)));
end