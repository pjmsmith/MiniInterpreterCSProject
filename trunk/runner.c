#include <stdio.h>

extern unsigned int llvm_main();

void print(unsigned int x)
{
    printf("%d\n", x>>2);
}

int main()
{
    printf("%d\n", llvm_main()>>2);
    return 0;
}
