//: generics/InstantiateGenericType.cpp
// C++, not Java!
// 在C++中 泛型操作new T() 很自然,很直观，也很安全，但在java中无法实现

template<class T> class Foo {
  T x; // Create a field of type T
  T* y; // Pointer to T
public:
  // Initialize the pointer:
  Foo() { y = new T(); }
};

class Bar {};

int main() {
  Foo<Bar> fb;
  Foo<int> fi; // ... and it works with primitives
} ///:~
