停车场管理系统需求：能停车、能取车、能显示有多少空车位。（不用考虑时间、费用及出口数量）

这次课需完成三个基本功能需求，即：停车、取车、显示有多少车位。
-------------------------------
Given  一个停车场，有空车位
When   停车
Should 成功，空车位-1
-------------------------------
Given  一个停车场，一辆车A
When   取车
Should 取到A，空车位+1
-------------------------------
Given  一个停车场，没有空车位 .
When   停车
Should fail
-------------------------------
Given  一个空的停车场
When   取车
Should fail
-------------------------------
Given  有效的停车凭证
When   取车
Should 取到原来停的车
-------------------------------
Given  无效的停车凭证
When   取车
Should 取不到原来停的车
-------------------------------

停车经理需求：

-------------------------------
Given  停车经理管理的停车仔
When   停车
Should 成功，空车位-1
-------------------------------


-------------------------------
Given  停车经理
When   停车
Should 成功，空车位-1
-------------------------------

停车经理报告需求：
-------------------------------
Given  报告中停车经理管理空余车位总数
When   停车
Should 成功，空车位-1
-------------------------------

-------------------------------
Given  报告中的停车仔管空余理车位总数
When   停车
Should 成功，空车位-1
-------------------------------