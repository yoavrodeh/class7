# Generics
### & a taste of the
## Java Collections framework

---
## Today
1. Generic classes.
1. Generic methods.
1. `copyOf`.
1. `List` and `ArrayList`.
1. Generic lower bounding (`<T extends ...>`).
  + `Comparable<E>`
  + `<E extends Comparable<E>>`.


---
## Resources
1. Deitel, chapter 11.
1. The Oracle Java Tutorials 
  + [Generics(updated) Oracle tutorial](https://docs.oracle.com/javase/tutorial/java/generics/index.html)
  
  
---
### Generics

Enable types (classes and interfaces) to be parameters when defining classes, interfaces and methods.
+ Stronger type checks at compile time.
+ Elimination of casts.
+ Enabling programmers to implement generic algorithms.

@css[fragment](*Let's say we want a container for a general object:*)



---
@code[java code-noblend](src/ObjectBox.java)

We can put any instance of any class inside, and then get it back.



---
@code[java code-noblend](src/MainForObjectBox.java)

This works well, but has drawbacks:
1. We must use a cast.
1. For that, we must take care of types ourselves. 
  + If we had `b.set(new Integer(34))`, casting would throw a `ClassCastException`.



---
@code[java code-noblend](src/Box.java)

Same as a normal class, except for the **type parameter** `<T>`,
which is used just like a normal type inside the class.



---
@code[java code-noblend](src/MainForBox.java)

+ We can think of `Box<Integer>` as if it is a new class with `Integer` instead of `T` everywhere. 
+ No need for casting, and compiler catches our type errors.



---
+ `Box` is a generic class.
  + `Box<String>` and `Box<Integer>` behave (almost) like normal classes.
+ A type parameter (`T`) cannot be primitive.
  + so cannot define `Box<int>`.
+ Although using the raw `Box` type (without `<>`) is possible, don't do it.



---
@code[java code-noblend](src/Pair.java)
+ There can be more than one type parameter.
+ Generic interfaces are also possible, 
  + A class implementing them can be generic or not.



---
@code[java code-noblend](src/StrIntPair.java)

As a side note, see how we use auto-boxing and auto-unboxing.




---
@code[java code-noblend](src/OrderedPair.java)

Then, we automatically have `OrderedPair<String, Integer>` which is 
practically the same as `StrIntPair`. 


---

Examine:
```java code-noblend
class OrderedPair<T1, T2> implements Pair<T1, T2> {
```
+ `T1` and `T2` are declared right after the class name: `OrderedPair<T1, T2>`. 
+ This is the **only** place you can declare a new type parameters.
+ They are then **used** in `Pair<T1, T2>` to specify exactly which version of the interface `Pair` we want. 
+ Of course, here this just means it is the same as those of `OrderePair`.

---
@code[java code-noblend](src/MainForPair.java)

+ The variables are of the interface type, and the objects are the class.
  + Not necessary, but a good habit in general. 
+ In the last two examples, Java **infers** what type to create. 




---
We can think of `Box<Integer>` as if it is new class with `Integer` everywhere. 
+ This is normally good intuition.
+ In reality, there is only one `Box` class.
  + For example, static variables are shared between all Boxes. 
  + Therefore, static methods cannot use the class's type parameters.


---
### Generic Methods

+ We can also define generic methods, where the type parameters 
  are restricted only to the method.
  + Static and non-static.
+ The type parameters are defined before the return type.


---
@code[java code-noblend](src/Methods.java)

It is possible to use `toString` and `equals` because `Object` has them.



---
@code[java code-noblend](src/MainForMethods.java)
@[3-4](When calling the generic method, we say what is the type.)
@[6-11](The `Pair` types must match. Otherwise we get a compilation error.)
@[13-14](Java can infer the generic type from the arguments of the function.)




---
### Java library Examples

+ `static <T> T[] copyOf(T[] original, int newLength)`
  + Copies the array, truncating or padding with nulls so the copy has the specified length.
+ `static <T> T[] copyOfRange(T[] original, int from, int to)`
  + Copies the specified range of the specified array into a new array.


---

Let's write our version of `copyOf`. But there is one problem:
  + We can't do `new T()` 
    + one reason is we don't know if `T` has such a constructor. 
  + But we also can't do `new T[..]`.
  + Why? a little [complicated.](https://stackoverflow.com/questions/2927391/whats-the-reason-i-cant-create-generic-array-types-in-java) 
  + We can create an `Object` array and use casting.



---
@code[java code-noblend](src/CopyOf.java)
@[1-9](`@suppressWarnings` is because java warns it doesn't know if the cast is safe.)
@[11-17](This is almost like `Arrays`'s code. It uses the efficient `System.arraycopy` static method, which works on `Object` arrays.)



---
### An Expandable Generic Array.
+ Let's write a class holding an array we can append to at the end, get elements from, etc.
+ It will be generic so we can use it for everything!
  


---
@code[java code-noblend](src/MyArray.java)
@[3-16]()
@[18-26](Why is there no need to check `i < 0`?)
@[28-39](Even more natural is to declare `public int indexOf(E e)`.)



---
@code[java code-noblend](src/MainForMyArray.java)
Very easy to use, and useful for any type we may need to keep!



---
### `ArrayList`

Java actually has a much expanded version of `MyArray<E>`, called `ArrayList<E>`.
+ It is a class that implements the interface `List<E>`.
+ Its implementation is very similar to ours.
  + The `indexOf` method is actually taken from there.
+ Part of **The Java Collections Framework**.
  + We will learn more about it, as it is very useful.


---
Some of `List<E>`'s methods are:
1. `add(E)`, adds at the end, and `add(int, E)`, at given index.
1. `set(int, E)`, `get(int)`, `remove(int)`.
1. `remove(Object o)`, `indexOf(Object o)` and `lastIndexOf(Object)`, all use `o.equals(Object)` to compare against the elements of the list.
  + It is of course inherited from `Object` but may be overriden in `o`.
  

---
@code[java code-noblend](src/ArrayListExample.java)
The `for` loop works well here. It would not work in `MyArray`.




---
@code[java code-noblend](src/Point.java)

If you write the method `equals(Point)` and not `equals(Object)`, it won't be used by `ArrayList`'s methods!



---
@code[java code-noblend](src/MainForPoint.java)
+ Without overriding `equals`, this would be `false`.
+ Because of polymorphism, when `contains(Object o)` calls `o.equals`,
  it uses `equals` of `Point`, and not the one of `Object`.



---
### Lower Bounding
+ A generic type has all the methods `Object` has.
+ They can be used, and we get the correct method version by polymorphism. 
+ We can require that a generic type implements an interface, or extends a class with the `extends` keyword. 

For example:
```java code-noblend
public interface HasName {
	public String getName();
}
```


---
@code[java code-noblend](src/Student.java)
Just an example class.



---
@code[java code-noblend](src/Names.java)
This requires that `E` must be a subtype of `hasName`, and so we can write
`e.getName()`.



---
@code[java code-noblend](src/MainForNames.java)
It is not possible to define `Names<String>` for example.



---
### `Comparable`
A very useful Java library interface is:
```java code-noblend
interface Comparable<T> {
	public int compareTo(T other)
}
```
+ A class that implements `Comparable<T>` can compare itself to objects of type `T`.
  + Normally, to objects of the same type as itself.
+ For example, `String` implements `Comparable<String>`.
  + It has a method `int compareTo(String other)`.



---
@code[java code-noblend](src/Student2.java)




---
@code[java code-noblend](src/CountLarger.java)
The idiom `E extends Comparable<E>` is very common, and says that this generic method can only work with types `E` that are comparable to themselves.



---
@code[java code-noblend](src/MainForCountLarger.java)


---
The Java library has good support for types that are comparable to themselves.
+ `Arrays.sort(Object[] a)` sorts according to `compareTo`.
  + It will throw a `ClassCastException` if `a` is not an array of `Comparable`.
+ Other methods of `Arrays` also use it, like `binarySearch`.
+ We will see more in the next lecture.

@css[fragment](*Another example:*)



---
@code[java code-noblend](src/SortedArray.java)
@[4-12](Here we can use `CompareTo`.) 
@[14-21]



---
@code[java code-noblend](src/MainForSortedArray.java)



---
## Exercise

Write a generic method 
that given an array of `E`, returns the element that appears the most in the array. 

For simplicity, implement an $O(n^2)$ algorithm. 

@css[fragment](solutions are in the package `exercise` in the source code.)



---
## Exercise

Write a generic class `MyMap`, which has
+ `put(K key, V value)`, which remembers the pair.
+ `V get(K key)`, which if there was a pair with `key` as the key, returns the `value`.

Don't worry about efficiency, and use two `ArrayList`'s: one to save the keys and one to save the values, taking care corresponding ones have the same index.


---

Lastly, write another solution to the last exercise:
+ Write a new class generic pair class which saves a key and a value (you can use `OrderedPair`). 
+ Have only one `ArrayList<Pair>` for saving pairs.
+ The generic pair class will need an `equals(Object)` for it to work well.
  + It will compare only the `key`.





