
#include <stdio.h>
#include <string.h>

// based on this example: http://d1dlalugb0z2hd.cloudfront.net/solutions/statemachine/show_telephone_call.png


typedef enum  callStatus {idle, washing, rinsing, spinDrying} status;

status startWashing(status currentStatus);
status startRinsing(status currentStatus);
status finishCall(status currentStatus);
status startSpinDrying(status currentStatus);
int getInput();
void printStatus(status currentStatus);

int main(int argc, char *argv[])
{
    char input;

    // by default, start in idle mode
    status currentStatus = idle;

    printStatus(currentStatus);

    do
    {
        input = getInput();
        switch(input)
        {
            case 'S':
                currentStatus = startWashing(currentStatus);
                break;
            case 'W':
                currentStatus = startRinsing(currentStatus);
                break;
            case 'R':
                currentStatus = startSpinDrying(currentStatus);
                break;
            case 'D':
                currentStatus = finishCall(currentStatus);
                break;
            default:
                puts("illegal input");
                break;
        }

        printStatus(currentStatus);

    } while (strcmp(&input, "D") != 0);

}

status startWashing(status currentStatus)
{
    status newStatus;

    if (currentStatus == idle)
    {
        newStatus = washing;
    }
    else
    {
        puts("error - can only start washing if machine is idle");
        newStatus = currentStatus;
    }

    return newStatus;
}

status startRinsing(status currentStatus)
{
    status newStatus;

    if (currentStatus == washing)
    {
        newStatus = rinsing;
    }
    else
    {
        puts("error - can only rinse after washing");
        newStatus = currentStatus;
    }

    return newStatus;
}
status startSpinDrying(status currentStatus)
{
    status newStatus;

    if (currentStatus == rinsing) {
        newStatus = spinDrying;
    }
    else
    {
        puts("error - can only spin dry after rinsing");
        newStatus = currentStatus;
    }

    return newStatus;
}

status finishCall(status currentStatus)
{
    status newStatus;

    if (currentStatus == spinDrying)
    {
        newStatus = idle;
        printf("BEEP, BEEP, BEEEEEEEEP \n");
    }
    else
    {
        puts("error - can only stop when done spin-drying");
        newStatus = currentStatus;
    }

    return newStatus;
}

int getInput()
{
    char input;

    printf ("Input latest event:\n");
    printf ("S - Start Washing\n");
    printf ("W - Wash Complete\n");
    printf ("R - Rinsing Complete\n");
    printf ("D - Spin Dry Complete\n");
    printf ("input: ");
    scanf ("%s", &input);
    return input;
}

void printStatus(status currentStatus)
{

    switch(currentStatus)
    {
        case idle:
            printf("Current Status = IDLE\n");
            break;
        case washing:
            printf("Current Status = WASHING\n");
            break;
        case rinsing:
            printf("Current Status = RINSING\n");
            break;
        case spinDrying:
            printf("Current Status = SPIN-DRYING\n");
            break;
        default:
            printf("SEVERE ERROR - CURRENT STATUS UNKNOWN");
            break;
    }

}