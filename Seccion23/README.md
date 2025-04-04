# Cloud Deployment
Is a technology model that allows access to computing resources (such as servers, storage, databases, networks, software, and more) over the internet, instead of relying on physical infrastructure.


## Cloud Service Models
We have different service:
1. **Infrastructure as a Service (IaaS).**

   Provides virtualized computing resources over the internet. It offers essential infrastructure components like virtual machines, storage, networking, and operating systems, allowing businesses to rent IT resources instead of maintaining physical servers.

    * **Examples:** AWS EC2, Google Compute Engine, Microsoft Azure Virtual Machines.
    * **Benefits:** Scalability, cost-efficiency, flexibility, and reduced maintenance.

2. **Container as a Service (CaaS)**

    Allows developers to manage and deploy containerized applications using cloud-based container orchestration services. It simplifies container management, networking, and security without dealing with the underlying infrastructure.
    
    * **Examples:** AWS Fargate, Google Kubernetes Engine (GKE), Azure Kubernetes Service (AKS).
    * **Benefits:** Portability, automation, rapid deployment, and better resource utilization.

3. **Platform as a Service (PaaS)**

    Provides a cloud-based platform where developers can build, test, and deploy applications without worrying about infrastructure management. It includes runtime environments, frameworks, and tools needed for software development.
    
    * **Examples:** Google App Engine, AWS Elastic Beanstalk, Heroku.
    * **Benefits:** Faster development, automated scaling, reduced infrastructure complexity, and built-in security.

4. **Function as a Service (FaaS)**

    Also known as "serverless computing," allows developers to run code in response to events without provisioning or managing servers. Functions execute on demand and automatically scale based on workload.
    
    * **Examples:** AWS Lambda, Google Cloud Functions, Azure Functions.
    * **Benefits:** Cost savings (pay-per-use model), automatic scaling, and reduced operational overhead.

5. **Software as a Service (SaaS)**

    Delivers fully functional software applications over the internet, eliminating the need for local installations. Users can access software through web browsers without handling updates, maintenance, or infrastructure.
    
    * **Examples:** Google Workspace (Docs, Drive), Microsoft 365, Dropbox, Salesforce.
    * **Benefits:** Accessibility, automatic updates, scalability, and lower upfront costs.

## Types of Cloud
1. **Public Cloud.** 

    Computing resources are owned and operated by third-party providers and shared among multiple organizations. It is cost-effective and scalable but offers limited control over security and customization.
    
    * **Examples:** AWS, Google Cloud, Microsoft Azure.
   
    * **Benefits:**
        * Pay-as-you-go pricing.
        * High scalability and availability.
        * No maintenance costs.
    
    * **Challenges:**
      * Less control over security.
      * Shared resources with other customers (multi-tenancy).

2. **Private Cloud.** 

    A private cloud is exclusively dedicated to a single organization. It provides greater control, security, and customization, making it ideal for businesses with strict compliance requirements.
    
    * **Examples:** VMware Private Cloud, OpenStack, IBM Cloud Private.
   
    * **Benefits:**
      * Enhanced security and privacy.
      * Greater flexibility and control.
      * Customizable infrastructure.
    
    * **Challenges:**
      * High cost of setup and maintenance.
      * Requires in-house IT management.

3. **Hybrid Cloud.** Combines public and private clouds, allowing data to move between them as needed.

4. **Multi-Cloud.** Uses multiple cloud providers to diversify risks and optimize services.

## AWS

### Amazon EC2 Basics Instance Families
An EC2 instance is a virtual machine (VM) that runs in the AWS Cloud. The instance type that you choose determines the hardware of the host computer used. Each instance offers different compute, memory, and storage capabilities.

### Decoding instance names
Instance names are a combination of the instance family, generation and size. They can also indicate additional capabilities, such as specific processor type or optimized networking performance. Let's use `m5z n.xlarge` as an example:

* Instance family (m): the first position represents the instance family where M is a general purpose instance subfamily.
* Instance generation (5): with higher number being the newest generation.
* Attribute (z): not all instances have one. It provides additional information about the instances capabilities, for example z indicates high frequency which is ideal for high single-thread performance..
* Additional information (n): not all instances have an additional attribute that details what the instance is optimized to do. For this case n stands for network.
* Size (xlarge): represents the size of the instance, which the larger the size, the more resources, such as CPU and memory.

Here is a list of additional items that might be seen in an instance name:

* a – AMD processors
* g – AWS Graviton processors
* i – Intel processors
* d – Instance store volumes
* n – Network optimization
* b – Block storage optimization
* e – Extra storage or memory
* z – High frequency

### EC2 Use Cases


### Services AWS
* **Elastic Compute Cloud (EC2)** is a cloud-based virtual machine (VM) service, which would be an IaaS, that gives us full control over the operating system, networking, and computing resource.
  * **Use Cases**
    * **_Hosting custom web applications._** Run web servers like Apache, Nginx, or Tomcat for full control over configurations.
    * **_High-performance computing (HPC)._** Use EC2 for scientific simulations, AI/ML training, or big data processing.
    * **_Running databases._** Deploy self-managed databases.
    * **_Hosting game servers._** Run multiplayer game servers requiring real-time performance.
    * **_VPN and proxy services._** Set up secure VPNs or private proxies.
    * **_Custom virtual machines._** Install and configure any OS, middleware, or security as needed.
    * **_CI/CD pipelines & dev/test environments._** Set up scalable environments for software development and testing.
* **Elastic Beanstalk** is a PaaS that automates application deployment and management. It provides servers, databases, load balancing, and scalability without requiring manual intervention.
  * **Use Cases**
    * **_Rapid application deployment._** Quickly deploy web applications without managing infrastructure.
    * **_Scalable web apps._** Ideal for apps that need auto-scaling and load balancing.
    * **_Microservices & API hosting._** Easily deploy backend APIs for mobile and web apps.
    * **_Startups & MVPs._** Quickly launch a product with minimal DevOps effort.
    * **_Enterprise applications._** Deploy internal business applications with ease.
    * **_Multi-language support._** Works with Java, Python, Node.js, Ruby, .NET, and more.
* **Amazon RDS** is a managed database service that simplifies the setup, operation, and scaling of relational databases. It automates database tasks like backups, patching, monitoring, and scaling.
  * **Use of case:** if you need a traditional relational database without worrying about infrastructure management, RDS is a great choice.
* **Elastic Container Service (ECS)** is a fully managed container orchestration service that allow us to run, manage, and scale Docker containers on AWS. It supports two types of scheduling models:
  1. EC2 Launch. We manage the EC2 instances that run our containers.
  2. Fargate Launch. AWS automatically manages the underlying infrastructure, and we only need to define and deploy our container.

  * **Use of case:**
    * **Microservices architecture.** ECS is ideal for deploying microservices where each service is containerized and interacts with other services.
    * **Web applications.** It can be used to deploy containerized web applications with components like front-end servers, back-end APIs, and databases.
    * **CI/CD pipelines.** Can be integrated with CI/CD pipelines to automate the deployment and testing of containerized applications.
    * **Batch processing.** Can manage batch jobs in containers for tasks such as data processing, analytics, image/video processing, or scientific simulations.
  
* **Identity and Access Management (IAM)** help us to securely control access to AWS resources. It enables us to manage users, groups, roles, and permissions to ensure that only authorized sers and applications can access your resources.