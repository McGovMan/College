#include <stdio.h>
#include <argp.h>
#include <string.h>
#include <stdlib.h>

char** generateMatrix(const char *key);
void printCipher(char** cipher);
void printOutput(char* output);
char* doCipher(const char* input, char** cipher, int encipher);
void getPositionInCipher(char* input, char** cipher, int* row, int* column);

/* Possible commandline flags */
struct arguments
{
    char *args[1];
    int verbose, encrypt, decrypt;
    char *key;
};

/* Possible commandline flags */
static struct argp_option options[] =
        {
                {"verbose", 'v', 0, 0, "Produce verbose output"},
                {"encrypt", 'e', 0, 0, "Encrypt the input"},
                {"decrypt", 'd', 0, 0, "Decrypt the input"},
                {"key",   'k', "CIPHER", 0, "Key used to randomise the cipher"},
                {0}
        };

/* Parse all the commandline arguments and set the relavent flags */
static error_t parse_opt (int key, char *arg, struct argp_state *state)
{
    struct arguments *arguments = state->input;

    switch (key)
    {
        case 'v':
            arguments->verbose = 1;
            break;
        case 'e':
            arguments->encrypt = 1;
            break;
        case 'd':
            arguments->decrypt = 1;
            break;
        case 'k':
            /* Convert key to uppercase */
            for (int i = 0; arg[i] != 0; i++)
                arg[i] = (char) toupper(arg[i]);
            arguments->key = arg;
            break;
        case ARGP_KEY_ARG:
            if (state->arg_num >= 3)
                argp_usage(state);
            arguments->args[state->arg_num] = arg;
            break;
        case ARGP_KEY_END:
            if (state->arg_num < 1)
                argp_usage(state);
            break;
        default:
            return ARGP_ERR_UNKNOWN;
    }
    return 0;
}

static struct argp argp = {options, parse_opt, "\"INPUT\"", "main -- encrypt/decrypt a string using a specified playfair ciphertext."};

int main (int argc, char **argv)
{
    struct arguments arguments;
    /* Set argument defaults */
    arguments.encrypt = 0;
    arguments.decrypt = 0;
    arguments.verbose = 0;
    arguments.key = "";

    /* Parse the arguments into the arguments struct */
    argp_parse (&argp, argc, argv, 0, 0, &arguments);

    if ((arguments.encrypt && arguments.decrypt) ||
        (!arguments.encrypt && !arguments.decrypt))
    {
        puts("Error:\n Choose one option: encrypt OR decrypt (-e/-d)");
        goto out;
    }

    /* Convert J->I & K->C in the key if they exist */
    for (int i = 0; i < strlen(arguments.key); i++)
    {
        if (arguments.key[i] == 'J') {
            arguments.key[i] = 'I';
        }
        else if (arguments.key[i] == 'K')
        {
            arguments.key[i] = 'C';
        }
    }

    char** cipher = generateMatrix(arguments.key);
    char* output = (arguments.encrypt && !arguments.decrypt) ?
            doCipher(arguments.args[0], cipher, 1) : doCipher(arguments.args[0], cipher, 0);

    printCipher(cipher);
    printOutput(output);

out:
    return 0;
}

char* doCipher(const char* input, char** cipher, int encipher) {
    char *output = malloc(256 * sizeof(char));

    if (encipher)
    {
        // Insert X between repeating characters
        for (int i = 0, y = 0; input[i] != 0; i++, y++) {
            output[y] = input[i];
            if (y % 2 == 0 && input[i] == input[i + 1]) {
                output[y + 1] = 'X';
                y++;
            }
        }

        for (int i = 0; output[i] != 0; i++) {
            if (output[i] == 'J') {
                output[i] = 'I';
                continue;
            }

            if (output[i] == 'K') {
                output[i] = 'C';
                continue;
            }

            // If we're not at the start of the pair, skip the iteration
            if (i % 2 != 0)
                continue;

            int iRow = 0, iPlus1Row = 0, iCol = 0, iPlus1Col = 0;
            getPositionInCipher(&output[i], cipher, &iRow, &iCol);
            getPositionInCipher(&output[i + 1], cipher, &iPlus1Row, &iPlus1Col);

            // Check if pair is on the same row
            if (iRow == iPlus1Row) {
                output[i] = cipher[iRow][(iCol + 1) % 5];
                output[i + 1] = cipher[iPlus1Row][(iPlus1Col + 1) % 5];
                continue;
            }

            // Check if the pairs are in the same column
            if (iCol == iPlus1Col) {
                output[i] = cipher[(iRow + 1) % 5][iCol];
                output[i + 1] = cipher[(iPlus1Row + 1) % 5][iPlus1Col];
                continue;
            }

            // Otherwise each letter gets replaced by the letter in its row
            // but in the other letters column
            output[i] = cipher[iRow][iPlus1Col];
            output[i + 1] = cipher[iPlus1Row][iCol];
        }
    } else {
        //TODO add decrypting ability
    }

    return output;
}

/* Prints a pretty version of the cipher matrix */
void printCipher(char** cipher)
{
    printf("---- Cipher Matrix ----\n");
    for (int i = 0; i < 5; i++)
    {
        for (int y = 0; y < 5; y++)
        {
            printf("| %c | ", cipher[i][y]);
            if (y == 4)
                puts("");
        }
    }
    printf("\n\n");
}

/* Prints the encoded/decoded input */
void printOutput(char* output)
{
    printf("---- Encoded/Decoded Answer ----\n");
    printf("Output := \"%s\"\n\n", output);
}

/* Generates a matrix with the key and fills in the rest with the remaining characters */
char** generateMatrix(const char* key)
{
    char **matrix = malloc(5 * sizeof(char*));
    char *used = malloc(24 * sizeof(char));
    int y = 0, i = 0;

    // Make space inside the strings
    for (int x = 0; x < 5; x++)
        matrix[x] =  malloc(6 * sizeof(char));

    // Copy the key into the matrix (ignoring repeating characters)
    for (; key[i] != 0; i++, y++) {
        if (!strchr(used, key[i])) {
            matrix[y / 5][y % 5] = key[i];
            strncat(used, &key[i], 1);
        } else
            y--;
    }

    // Copy the alphabet into the matrix (ignoring J, K and repeating characters)
    for (i = 65; y < 24; i++, y++)
    {
        char tmp = (char) i;
        if (!strchr(used, tmp) && tmp != 'J' && tmp != 'K') {
            matrix[y / 5][y % 5] = tmp;
            strncat(used, &tmp, 1);
        } else
            y--;
    }

    // Replace last character with a space
    matrix[4][4] = (char) 32;

    return matrix;
}

/* Gets the position of a character in the cipher matrix */
void getPositionInCipher(char* input, char** cipher, int* row, int* column)
{
    for (int i = 0; i < 5; i++)
        for (int y = 0; y < 5; y++)
            if (cipher[i][y] == *input)
            {
                *row = i;
                *column = y;
            }
}