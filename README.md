# yw-job

schedule用于管理executor
executor用于管理task

维护一个简单的task队列，发现有需要运行的task后，找对对应executor然后远程调用exectuor去执行

这边存储task表和exectuor表

Executor：

![image](https://user-images.githubusercontent.com/82632999/175854553-efac7afd-848b-4549-bced-ccaa253aac43.png)

Task

![image](https://user-images.githubusercontent.com/82632999/175854681-d3fefd27-24aa-4145-8236-e8e6936be55e.png)

简单的架构图

![无标题流程图](https://user-images.githubusercontent.com/82632999/175855455-e0340bbd-3669-4133-bb9b-7a1b5ac10f46.png)
