#include <stdio.h>

extern unsigned int llvm_main();

int main()
{
    printf("%d\n", llvm_main()>>2);
    return 0;
}
