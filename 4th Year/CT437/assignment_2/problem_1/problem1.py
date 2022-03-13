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

r1 = 0B11001010110011001010011010110010
r2 = 0B00110110111100101001010010011010
lfsr1 = handleLFSR(r1, r2, 20)
print("LFSR1 from R1 & R2:", lfsr1)