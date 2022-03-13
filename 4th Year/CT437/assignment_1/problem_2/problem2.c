#include <stdio.h>
#include <argp.h>
#include <string.h>
#include <stdlib.h>

/* Possible commandline flags */
struct arguments
{
    char *args[1];
    int verbose, english, german;
    char* filename;
};

/* Possible commandline flags */
static struct argp_option options[] =
        {
                {"verbose", 'v', 0, 0, "Produce verbose output"},
                {"english", 'e', 0, 0, "Provided English input file"},
                {"german", 'g', 0, 0, "Provided German input file"},
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
            arguments->english = 1;
            break;
        case 'g':
            arguments->german = 1;
            break;
        case ARGP_KEY_ARG:
            if (state->arg_num >= 3)
                argp_usage(state);
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

static struct argp argp = {options, parse_opt, "filename", "main -- frequency analysis of pairs of letters "};

int main (int argc, char **argv) {
    struct arguments arguments;
    /* Set argument defaults */
    arguments.filename = "";
    arguments.verbose = 0;
    arguments.english = 0;
    arguments.german = 0;

    /* Parse the arguments into the arguments struct */
    argp_parse(&argp, argc, argv, 0, 0, &arguments);

    puts(arguments.args[0]);

}