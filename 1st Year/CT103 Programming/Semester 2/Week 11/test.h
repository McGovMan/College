//
//  test.h
//
//  the purpose of TEST() is to replicate assert(), but without calling
//  abort()
//

#ifndef assert_test_h
#define assert_test_h

#define TEST(e)  \
((void) ((e) ? 0 : __TEST (#e, __FILE__, __LINE__)))

#define __TEST(e, file, line) \
((void)printf ("%s:%u: failed assertion '%s'\n", file, line, e))

#endif