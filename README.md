# StudentManagerSystem
Student Management System - Account Security Module  A robust Java implementation of a student system's authentication layer. Features advanced validation logic, dynamic captcha verification, and anti-brute-force login protection. Built with OOP principles and ArrayList persistence.

# StudentManagerSystem (学生管理系统 0.0 版) 🚀

这是一个基于 Java 开发的、包含用户安全验证和学生信息管理的综合系统。

## 🌟 项目亮点
- **模块化设计**：登录注册模块 (`app`) 与 业务逻辑模块 (`studentsystem`) 相互独立，逻辑清晰。
- **安全验证**：
    - 登录包含 **4 位随机验证码** 校验。
    - 登录失败 **3 次自动锁定** 账号。
    - 完整的注册校验（用户名、身份证、手机号格式检查）。
- **找回密码**：支持通过身份证号和手机号双重验证重置密码。
- **CRUD 业务**：学生信息的增删改查，支持 ID 唯一性检查。

## 🛠️ 技术栈
- **语言**：Java (JDK 17+)
- **集合**：`ArrayList` (内存级别数据存储)
- **概念**：面向对象编程 (OOP)、方法封装、流程控制、集合操作。

## 📂 文件说明
| 文件名 | 作用 |
| :--- | :--- |
| `app.java` | **程序入口**，负责用户登录、注册、找回密码逻辑。 |
| `studentsystem.java` | **核心业务**，负责学生信息的增删改查。 |
| `student.java` | 学生对象模型（id, 姓名, 年龄, 住址）。 |
| `user.java` | 用户对象模型（用户名, 密码, 身份证, 手机号）。 |

## 🚀 如何运行
1. 下载或克隆本项目。
2. 在 IDEA 中打开。
3. 运行 `app.java` 的 `main` 方法即可开始体验。

---
*由 0.0 开发。坚持代码逻辑的严谨性。*
