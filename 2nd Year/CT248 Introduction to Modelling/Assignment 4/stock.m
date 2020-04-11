function [a] = stock(Trials, Starting, Max, Min, Min_Change, Max_Change)
    a = zeros(Trials, 1);
    a(1) = Starting;
    
    for i = 2:Trials
        z = a(i-1) + change(Min_Change, Max_Change);
        if z <= Max && z >= Min
            a(i) = z;
        else
            a(i) = a(i-1);
        end
    end
end

function state = roll()
    r = rand();
    if r < 0.5
        state = -1;
    else
        state = 1;
    end
end

function change = change(Min_Change, Max_Change)
    r = roll();
    change = (((Max_Change - Min_Change) * rand()) + Min_Change) * r;
end