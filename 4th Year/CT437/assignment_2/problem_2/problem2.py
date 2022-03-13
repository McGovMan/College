# Generate a register with 32 bits - all zeros except a 1 at the beginning and end
# state = (1 << 31) | 1

# Get clocking bit in register
def getClockingBit(r):
    return (r ^ (r >> 14) ^ (r >> 17) ^ (r >> 18) ^ (r >> 19)) & 1

# Get majority bit of the two registers
def getMajorityBit(r1, r2):
    return r1 & 1 ^ r2 & 1

# Shift the register to the right and put the new bit at the start
def shiftRegister(r, b):
    return (r >> 1) | (b << 31)

# Will generate a stream cipher give two registers
def handleLFSR(r1, r2, i):
    out = ""
    for x in range(0, i):
        m_bit = getMajorityBit(r1, r2)
        r1_c_bit = getClockingBit(r1)
        r2_c_bit = getClockingBit(r2)

        out += str(m_bit)

        r1 = (r1 >> 1) | (r1_c_bit << 31)
        r2 = (r2 >> 1) | (r2_c_bit << 31)
    return out

def distributionTest(lfsr):
    num_of_zeros = lfsr.count("0")
    num_of_ones = lfsr.count("1")
    print("Number of Zeros: " + str(num_of_zeros))
    print("Number of Ones: " + str(num_of_ones) + "\n")

# Partially From https://www.youtube.com/watch?v=uz102bgyvZQ
def longestRepeatingSubstring(lfsr, match):
    lo, up, finlo, finup = 0, 1, 0, 1
    while up < len(lfsr):
        if lfsr[up] != lfsr[up-1]:
            if finup - finlo < up - lo and lfsr[lo] == match:
                finlo, finup = lo, up
            lo = up
        up += 1
    if finup - finlo < up - lo:
        finlo, finup = lo, up
    return lfsr[finlo:finup]

def longestRunTest(lfsr):
    print("Longest run of zeros: " + str(len(longestRepeatingSubstring(lfsr, '0'))))
    print("Longest run of ones: " + str(len(longestRepeatingSubstring(lfsr, '1'))) + "\n")

def repetitionsTest(lfsr):
    for x in range(3, 8):
        print("Runs of length " + str(x))
        # This includes runs inside of runs
        # E.g. if we look for 111 runs, and 1111 exists, 111 will be found in 1111
        print("Zeros: " + str(lfsr.count("0" * x)))
        print("Ones: " + str(lfsr.count("1" * x)))

# Do the tests outlined in the assignment brief
def handleTests(lfsr):
    distributionTest(lfsr)
    longestRunTest(lfsr)
    repetitionsTest(lfsr)

r1 = 0B11001010110011001010011010110010
r2 = 0B00110110111100101001010010011010
lfsr1 = handleLFSR(r1, r2, 10000)
print("\n--- LFSR 1 ---")
#print("LFSR1 from R1 & R2:", lfsr1)
handleTests(lfsr1)

r3 = 0B10111011111010010101101111101101
r4 = 0B00111011000111111011110110101010
lfsr2 = handleLFSR(r3, r4, 10000)
print("\n--- LFSR 2 ---")
#print("LFSR1 from R1 & R2:", lfsr2)
handleTests(lfsr2)

r5 = 0B11110101111001001101000001011000
r6 = 0B01111010010011110100000111000100
lfsr3 = handleLFSR(r5, r6, 10000)
print("\n--- LFSR 3 ---")
#print("LFSR1 from R1 & R2:", lfsr3)
handleTests(lfsr3)

r7 = 0B00000010010101001111111110011111
r8 = 0B10010000111011000010011000000110
lfsr4 = handleLFSR(r7, r8, 10000)
print("\n--- LFSR 4 ---")
#print("LFSR1 from R1 & R2:", lfsr4)
handleTests(lfsr4)

r9 = 0B10000111011011001101011111001100
r10 = 0B11010110110000101110111100100111
lfsr5 = handleLFSR(r9, r10, 10000)
print("\n--- LFSR 5 ---")
#print("LFSR1 from R1 & R2:", lfsr5)
handleTests(lfsr5)

# I think the results from the number of runs of i repetitions of 
# either 0s or 1s, with 3 < i < 7 (e.g. “0000”,“1111”, “00000”, etc.)
# are completely within my estimatimations and none of the tests for 
# lfsr1-lfsr5 were unexpected