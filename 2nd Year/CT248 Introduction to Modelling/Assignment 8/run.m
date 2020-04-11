f = @(t,x,r,K) r*x*(1-x/K);

START = 0; END = 100;

test_r = [0.10 0.11 0.12 0.13 0.14];
K = 10000;
P = 10;
res = [];

res(:,1) = [0:100];

for i = 1:5
 [t,y] = ode45(f, [START:END], P,odeset,test_r(i),K);
 res(:,i+1) = y;
 plot(t, y,'-o');
 hold on
end

res(1:5,:)