# Movie Application

Build Restful for a Movie Application using Spring Boot, Mysql, JPA and Hibernate.

#Scale

One of solutions is database scalability. SQL queries are optimized and implemented indexing strategies.

Second solution is that Cache (Redis or in memory) is used instead of daatabases.

Multiple copies of an application are load-balanced accross servers is the X-axis.

In a growing, evolving microservices ecosystem where traffic is steadily increasing, each microservice needs to be able to scale with the entire system without experiencing performance issues. To ensure our microservices are scalable and performant, we need a few things from each microservice. We need to understand the scale of growth both quantitatively and qualitatively so that we can prepare for expected growth. We need to use our hardware resources efficiently, be aware of resource bottlenecks and requirements, and make appropriate capacity planning. We need to make sure that a microservice's dependencies will scale with it. We need to manage traffic in a scalable and performance way. We have to handle and process tasks in a performance way.

<b><u>We can do autoscaling as following:</b></u> <br>
+ To provide resources to the different parts of the system that need it. Because resources are limited in any system, it is best to allocate resources to the parts of the system that need them, and not to over- or under-utilize any part of these resources.

+ It ensures that resources are scaled up only when needed and scaled down when traffic drops.

+ Auto Scaling lets you build scaling plans that automate how groups of different resources respond to changes in demand. You can optimize availability, costs, or a balance of both. AWS Auto Scaling automatically creates all of the scaling policies and sets targets for you based on your preference.

Using microservices gives us granular control over the performance of our application.

