from math import sqrt
import random


def generatePrimeNumbers():
  primeList = [i for i in range(10000,100000) if checkPrime(i)]
  n = random.choice(primeList)
  print(n)
  return n
  
def checkPrime(num):
   # Checking that given number is more than 1  
    if num > 1:  
        # Iterating over the given number with for loop  
        for j in range(2, int(num/2) + 1):  
            # If the given number is divisible or not  
            if (num % j) == 0:  
                return False  
        # Else it is a prime number  
        else:  
            return True
    # If the given number is 1  
    else:  
        return False 

# Get the secret number
def generateSecretNumber(prime):
    secret = []
    for i in range(10000,100000):
        if i < prime:
            secret.append(i)
    
    return random.choice(secret)

# Find a primitive root of the prime number
# I went with finding the smallest one
def findPrimitive( n) :
    s = set()
 
    # Find value of Euler Totient function
    # of n. Since n is a prime number, the
    # value of Euler Totient function is n-1
    # as there are n-1 relatively prime numbers.
    phi = n - 1
 
    # Find prime factors of phi and store in a set
    primefactors(s, phi)
 
    # Check for every number from 2 to phi
    for r in range(2, phi + 1):
        # Iterate through all prime factors of phi.
        # and check if we found a power with value 1
        flag = False
        for it in s:
 
            # Check if r^((phi)/primefactors)
            # mod n is 1 or not
            if (power(r, phi // it, n) == 1):
 
                flag = True
                break
             
        # If there was no power with value 1.
        if (flag == False):
            return r
 
    # If no primitive root found
    return -1

# Utility function to store prime
# factors of a number
def primefactors(s, n) :
    # Print the number of 2s that divide n
    while (n % 2 == 0) :
        s.add(2)
        n = n // 2
 
    # n must be odd at this po. So we can 
    # skip one element (Note i = i +2)
    for i in range(3, int(sqrt(n)), 2):
         
        # While i divides n, print i and divide n
        while (n % i == 0) :
 
            s.add(i)
            n = n // i
         
    # This condition is to handle the case
    # when n is a prime number greater than 2
    if (n > 2) :
        s.add(n)
        
""" Iterative Function to calculate (x^n)%p in O(logy) */"""
def power(x, y, p):
    res = 1 # Initialize result
 
    x = x % p # Update x if it is more
              # than or equal to p
 
    while (y > 0):
 
        # If y is odd, multiply x with result
        if (y & 1):
            res = (res * x) % p
 
        # y must be even now
        y = y >> 1 # y = y/2
        x = (x * x) % p
 
    return res

# Generates the public value
def generatePublicValue(prime, root, secret):
    #YA = a^x mod q 
    Y = (root**secret) % prime
    #print("here ", root**secret)
    return Y

# Generates the secret value
def generateSecretKey(prime, public, secret):
    #K = (Y)^X mod q
    K = (public**secret) % prime
    
    return K   

# Brute force search for the secret value
# We know it must be less then prime value
def MitM(root, prime, publicKey):
    for i in range(1, prime-1):
        if generatePublicValue(prime, root, i) == publicKey:
            return i

def main():
  #prime = generatePrimeNumbers()
  prime = 77951
  #root = findPrimitive(prime)
  root = 11
  
  # Problem 1
  # User Bob
  BobSecret = generateSecretNumber(prime)
  BobPublic = generatePublicValue(prime, root, BobSecret)
  
  # User Alice
  AliceSecret = generateSecretNumber(prime)
  AlicePublic = generatePublicValue(prime, root, AliceSecret)
  
  # Jimmy with Alice
  JimmyKey = generateSecretKey(prime, AlicePublic, BobSecret)
  print("Jimmy's Secret Key", JimmyKey)  
  
  # Alice with Jimmy
  AliceKey = generateSecretKey(prime, BobPublic, AliceSecret)
  print("Alice's Secret Key", AliceKey)
  print("")
  
  # Problem, part 1
  # Malicious user Mallory
  MallorySecret = generateSecretNumber(prime)
  
  # Mallory with Bob
  MalloryBobKey = generateSecretKey(prime, BobPublic, MallorySecret)
  print("MalloryBobKey: ", MalloryBobKey)
  
  
  #Mallory with Alice
  MalloryAliceKey = generateSecretKey(prime, AlicePublic, MallorySecret)
  print("MalloryAliceKey: ", MalloryAliceKey)
  print("")
  
  #Problem 2, part 2
  #MiTM attack for Bob
  BobFoundSecret = MitM(root, prime, BobPublic)
  print("Bob Found Secret Value: ", BobFoundSecret)
  print("Bob Oringinal Secret Value: ", BobSecret)
  print("")
  
  #MiTM attack for Alice
  AliceFoundSecret = MitM(root, prime, AlicePublic)
  print("Alice Found Secret Value: ", AliceFoundSecret)
  print("Alice Oringinal Secret Value: ", AliceSecret)

if __name__ == "__main__":
    main()
