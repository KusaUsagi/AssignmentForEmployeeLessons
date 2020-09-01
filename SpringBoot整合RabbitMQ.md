SpringBoot整合RabbitMQ

RabbitMQ是一个由erlang开发的AMQP的开源实现

核心概念

Message

消息，消息是不具名的，它由消息头和消息体组成。消息是不透明的，而消息头则由一系列的可选属性组成，这些属性包括routing-key（路由键）、priority（相对于其他消息的优先权）、delivery-mode（指出该消息可能需要持久性存储）等。

Publisher

消息的生产者，也是一个向交换器发布消息的客户端应用程序。



Exchange

交换器，用来接收生产者发送的消息并将这些消息路由给服务器中的队列

Exchange有4种类型：direct（默认），fanout，topic和headers。不同类型的Exchange转发消息的策略有所区别。 



Queue

消息队列，用来保存消息直到发送给消费者，它是消息的容器，也是消息的终点。一个消息可投入一个或多个队列。消息一直在队列里面，等待消费者连接到这个队列将其取走。



Binding

绑定，用于消费队列和交换器之间的关联。一个绑定就是基于路由键将交换器和消息队列连接起来的路由规则，所以可以将交换器理解成一个由绑定构成的路由表。

Exchange和Queue绑定可以是多对多关系。



Connection

网络连接，比如一个TCP连接。



Channel

新到，多路复用连接种的一条独立的双向数据流通道。



Consumer

消息的消费者，表示一个从消息队列中取得消息的客户端程序

VirtualHost

虚拟主机，表示一批交换器，消息队列和相关对象。

Broker

表示消息队列服务器实体



RabbitMQ运行机制

AMPQ中增加了Exchange和Binding的角色，生产者把消息发布发哦Exchange上，消息最终到达队列并被消费者接收，而Binding决定交换器的消息应该发送到哪个队列

Producer->Broker->Exchange根据路由键->Binding->Queue->Consumer

核心就是交换器和绑定规则。

direct 单播模式

fanout 广播模式

topic 根据匹配规则有选择性的进行广播