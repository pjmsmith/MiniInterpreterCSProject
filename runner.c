#include <stdio.h>

extern unsigned int llvm_main();

int main()
{
    printf("Result of LLVM: %d\n", llvm_main()>>2);
    return 0;
}
