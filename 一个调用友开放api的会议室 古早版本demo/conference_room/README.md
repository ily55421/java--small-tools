# conference_room
会议室预约系统：基于Java语言和MySQL数据库。开发工具使用IDEA。
本项目是我为我们学校经管学院开发的会议室预约系统，基于SSM框架，权限管理使用Shiro框架。用户权限分为普通用户和管理员。普通用户可以申请会议室使用，也可以
取消申请。管理员可以管理会议室(包括会议室信息的增删改查)和处理普通用户的会议室申请，也可以管理用户信息。
sql:数据库SQL文件，只存放表结构，数据没有包含在内。
src:源码文件夹。
config:配置文件。
注意src和config都是Sources Folder。
本项目采用maven管理项目，如果项目运行报Spring错，请检查自己maven导入jar中是否有个Maven:org.springframework: spring-2.5.6.SEC03.jar，如果有，删之。
