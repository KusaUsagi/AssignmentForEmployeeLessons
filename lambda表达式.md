##函数式接口
4. lambda表达式的本质：作为函数式接口的实现

5. 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口（@FunctionalInterface）
  java内置四大函数式接口

  |函数式接口|参数类型|返回类型|用途|
  | ---- | ---- | ---- | ---- |
  |Consumer<T>消费型接口|T|void|对类型为T的对象应用操作，包含方法，void accept(T t)|
  |Supplier<T>供给型接口|无|T|返回类型为T的函数，包含方法：T get()|
  |Function<T,R>函数型接口|T|R|对类型为T的对象应用操作，并返回结果。结果是R类型的对象。包含方法：R  apply(T t)|
  |Predicate<T>断定型接口|T|boolean|确定类型为T的对象是否满足某约束，并返回boolean值。包含方法：boolean test(T t)|
  
  
  

  
