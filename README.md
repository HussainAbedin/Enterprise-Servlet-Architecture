Lecture #1:
========================================================================================================================================================================
# Java Web & Distributed Applications - Servlet Foundation
---

## 🧱 Types of Applications Built Using Java

### 1. Standalone Applications (JSE)
- Command-Line Interface (CUI) Applications  
- Graphical User Interface (GUI) Applications

### 2. Enterprise Applications (JEE and Frameworks)
- Web Applications  
- Distributed Applications

---

## 🔍 Web vs Distributed Applications

### 🌐 Web Applications
- **Definition:** Server-side applications designed **without** distributing logic across multiple JVMs.
- **Technologies:** CGI, Servlet, JSP  
- **Goal:** Generate **dynamic response** for web clients via browsers.  
- **Execution Environment:** Requires a **Web Server** (e.g., Tomcat, Jetty)  
- **Client Type:** Web Clients (browsers)

### 🤝 Distributed Applications
- **Definition:** Server-side applications with logic **distributed** over multiple JVMs.
- **Technologies:** RMI, EJBs, Web Services  
- **Goal:** Enable communication between local and remote machines (e.g., B2B model)  
- **Execution Environment:** Requires an **Application Server**  
- **Client Type:** Any client (not just browsers)

---

## ⚙️ Web Server vs Application Server

| Feature                | Web Application           | Distributed Application       |
|------------------------|---------------------------|-------------------------------|
| Technology             | Servlet, JSP              | RMI, EJB, Web Services        |
| Execution              | Web Server (e.g., Tomcat) | Application Server            |
| Model                  | Client to Server          | Business to Business          |
| Scope                  | Browser-based             | Any remote service-based      |

---

## 🖥 Web Programming: Static vs Dynamic Responses

### 📄 Static Response
- Same for all users and times.  
- Example: Gmail login page, ICICI homepage.

### ⚡ Dynamic Response
- Varies per user or time.  
- Example: Gmail inbox, bank balance info.

---

## 🌐 Static Response Flow (HTML)
1. Client requests static file (HTML/CSS).
2. Webserver checks resource availability.
3. Responds with file or 404 error.

> **Note:** No server-side processing needed for static files.

---

## 🚀 Dynamic Response Flow (Servlet/JSP)
1. Client sends request to Webserver.
2. Webserver checks resource type (static/dynamic).
3. For dynamic:
   - Webserver forwards to **WebContainer**.
   - WebContainer executes helper app (Servlet/JSP).
   - Response sent back to client.

> **Error Handling:**
- Missing resource → 404  
- Runtime error → 500

---

## 💡 Why Servlet over CGI?

| Feature       | CGI                          | Servlet                          |
|---------------|------------------------------|-----------------------------------|
| Language      | C (Process-based)            | Java (Thread-based)              |
| Resource Use  | Heavy (new process per request) | Lightweight (new thread per request) |
| Scalability   | Poor                         | High                             |
| Performance   | Low                          | High                             |

---

## 💡 Why JSP over Servlet?

| Feature               | Servlet                           | JSP                            |
|------------------------|------------------------------------|---------------------------------|
| Skill Requirement      | Java knowledge required            | HTML/Design skills sufficient  |
| Focus Area             | Business Logic                     | Presentation Logic             |
| Code Compilation       | Manual (requires reload)           | Auto-compiled                  |
| MVC Placement          | Controller                         | View                           |
| Separation of Logic    | Not clearly separated              | Clearly separated              |

---

## 🧰 Web Server: Apache Tomcat

### 📌 Architecture
- **Tomcat:** Provided by Apache Foundation  
- **Web Container:** Manages and executes Servlet & JSP  
  - **Catalina:** Servlet container  
  - **Jasper:** JSP container  

### 🖱 How to Start
- Navigate to `bin/` folder in Tomcat.
- Run `tomcat9.exe`
- Access via: [http://localhost:9999](http://localhost:9999)

---

## 📚 Servlet API Overview

### Packages:
- `javax.servlet.*`  
- `javax.servlet.http.*`

### Key Interfaces / Classes

| Package               | Component                       | Description                          |
|------------------------|----------------------------------|--------------------------------------|
| `javax.servlet`        | `Servlet`, `GenericServlet`, `ServletConfig`, `ServletContext`, `RequestDispatcher`, `ServletRequest`, `ServletResponse` | Core Servlet interfaces              |
| `javax.servlet.http`   | `HttpServletRequest`, `HttpServletResponse`, `HttpSession`, `HttpServlet` | HTTP-specific components             |

---

## 🔎 Sample Interface: Servlet

```
public interface javax.servlet.Servlet {
  void init(ServletConfig config) throws ServletException;
  ServletConfig getServletConfig();
  void service(ServletRequest req, ServletResponse res) throws ServletException, IOException;
  String getServletInfo();
  void destroy();
}
```
Lecture #2:BIG-7 Methods and Servlet Basics
============================================================================================================================================================================
```
What is the difference between GET and POST request types?

+-----------------------------+-----------------------------------------------------------+------------------------------------------------------------+
| Feature                    | GET Request                                               | POST Request                                               |
+-----------------------------+-----------------------------------------------------------+------------------------------------------------------------+
| Purpose                    | Retrieve information from server                          | Send data to server (e.g., insert/update)                  |
| Data in URL                | Yes, data is in URL as query string                       | No, data is sent in the request body                       |
| Example                    | /test?source=blr&dest=shivamogga                          | /test (data hidden in body)                                |
| Security                   | Less secure (data visible in URL)                         | More secure (data not visible in URL)                      |
| Data Size Limit            | Small amount (due to URL length limit)                    | Large amount of data supported                             |
| Bookmarking/Caching        | Supported                                                 | Not supported                                              |
| Idempotent                 | Yes                                                       | No                                                         |
| Safe                      | Yes                                                       | No                                                         |
| Use Case                  | Read operations like search/query                         | Write operations like uploading, submitting forms          |
+-----------------------------+-----------------------------------------------------------+------------------------------------------------------------+

NOTE:
-----
- **Idempotent Request**: If repeating the request multiple times doesn't change the result.
  → GET is idempotent, POST is not.

- **Safe Request**: If repeating the request doesn't affect server state.
  → GET is safe, POST is not.


HOW TO SEND REQUESTS
---------------------

Send GET Request:
-----------------
1. Type the address in browser URL bar and press Enter.
2. Click a hyperlink:
   <a href=" ">CLICK HERE</a>
3. Submit a form using method="GET":
   <form method="GET">
     <!-- form fields -->
   </form>
4. Submit a form without specifying method (default is GET):
   <form>
     <!-- form fields -->
   </form>

Send POST Request:
------------------
1. Submit a form using method="POST":
   <form method="POST">
     <!-- form fields -->
   </form>


HTTP REQUEST & RESPONSE CYCLE
-----------------------------
- When the request is sent, HTTP Protocol creates HTTPRequest object.
- Data is filled in HTTPRequest object and sent to server.
- Server processes and sends back HTTPResponse object.
- Browser receives HTTPResponse and displays result.

WEB APPLICATION STANDARD DIRECTORY STRUCTURE
--------------------------------------------
ProjectName/
│
├── WEB-INF/
│   ├── web.xml               --> Deployment descriptor
│   ├── classes/              --> .class files
│   └── lib/                  --> jar libraries
│
├── src/main/java/            --> .java source files
├── pages/                    --> .jsp files


HOW TO CREATE SERVLET IN JAVA?
==============================
There are 3 approaches:
a. Implementing Servlet interface
b. Extending GenericServlet (Abstract Class)
c. Extending HttpServlet (Abstract Class)


1. Servlet Interface
--------------------
public interface Servlet {
  void init(ServletConfig config) throws ServletException;
  ServletConfig getServletConfig();
  void service(ServletRequest req, ServletResponse res)
    throws ServletException, IOException;
  String getServletInfo();
  void destroy();
}

Servlet Lifecycle (performed by container):
-------------------------------------------
a. Loading                 → Static block executes
b. Instantiation           → Constructor executes
c. Initialization          → init(ServletConfig config)
d. Request Processing      → service(ServletRequest, ServletResponse)
e. De-Instantiation        → destroy()

Example:
--------
import java.io.*;
import javax.servlet.*;

public class FirstServlet implements Servlet {

  static {
    System.out.println("FirstServlet.class file is loading...");
  }

  public FirstServlet() {
    System.out.println("FirstServlet Object is instantiated...");
  }

  public void init(ServletConfig config) throws ServletException {
    System.out.println("Servlet initialization...");
  }

  public ServletConfig getServletConfig() {
    return null;
  }

  public void service(ServletRequest request, ServletResponse response)
    throws ServletException, IOException {
    System.out.println("Servlet Request Processing...");
  }

  public String getServletInfo() {
    return null;
  }

  public void destroy() {
    System.out.println("Servlet De-Instantiation...");
  }
}


2. URL Mapping (web.xml)
------------------------
<web-app>
  <servlet>
    <servlet-name>DemoServlet</servlet-name>
    <servlet-class>FirstServlet</servlet-class>
  </servlet>

  <servlet-mapping>
    <servlet-name>DemoServlet</servlet-name>
    <url-pattern>/test</url-pattern>
  </servlet-mapping>
</web-app>


3. Compile and Set Environment
------------------------------
Set path:
  set path=C:\Program Files\Java\jdk1.8\bin
Set classpath:
  set classpath=.;C:\Tomcat 9.0\lib\servlet-api.jar

Copy compiled .class file:
  → Copy to: WEB-INF/classes/

4. Start Tomcat Server:
-----------------------
Go to:
  C:\Tomcat 9.0\bin\
Run:
  tomcat9.exe

5. Send Request to Servlet:
---------------------------
Type in browser:
  http://localhost:9999/FirstApp/test
```

Lecture #3:
===========================================================================================================================================================================

**Standard Folder Structure of Webapps in Tomcat Server**

```
TomcatRoot/
|
|-- webapps/   <-- Deployment Folder
     |
     |-- SecondApp/
          |-- WEB-INF/
               |-- web.xml         <-- Deployment Descriptor
               |-- classes/
                    |-- *.class   <-- Compiled Servlet Classes
          |-- src/main/java/
               |-- *.java        <-- Source Files
```

> **Why is webapps called Deployment Folder?**

* When Tomcat starts, it scans `webapps/` and loads all the projects inside it.
* These projects are moved to the execution area (ready to serve requests).
* For each app, Tomcat creates a **ServletContext** object.
* Tomcat reads each app's `web.xml` to understand URL mappings of servlets.

---

**Sending a Request to Application**

```
http://localhost:9999/[ApplicationName]/[url-pattern]
```

**Example:** `http://localhost:9999/SecondApp/demo`

**Tomcat Request Flow:**

1. Browser sends request → `http://localhost:9999/SecondApp/demo`
2. HTTP protocol creates `HttpRequest` object based on request type.
3. Tomcat extracts context and URL pattern from request.
4. Container reads `web.xml` to locate servlet for the URL.
5. Servlet Lifecycle is executed:

```
a. Loading                -> Class c = Class.forName("SecondServlet");
b. Instantiation          -> Object obj = c.newInstance();
c. Initialization         -> obj.init(ServletConfig config);
d. Request Processing     -> obj.service(ServletRequest, ServletResponse);
e. De-Instantiation       -> obj.destroy();
```

> **ServletRequest** → Used to get input from client.
> **ServletResponse** → Used to send output to browser.

---

**First vs Second Request Output**

```
First Request:
- Loading...
- Instantiation...
- Initialization...
- Request Processing...

Second Request:
- Request Processing...
```

**Why Second Request is Faster?**

* Servlet is already loaded, instantiated, and initialized.

**How to Maintain Uniform Response Time?**
→ Use `<load-on-startup>` tag in web.xml

```xml
<servlet>
  <servlet-name>DemoServlet</servlet-name>
  <servlet-class>SecondServlet</servlet-class>
  <load-on-startup>10</load-on-startup>
</servlet>
```

> Same can be done using annotation:

```java
@WebServlet(urlPatterns="/test", loadOnStartup=10)
```

---

**Limitation of Implementing Servlet Interface**

* Must implement all methods → Code becomes lengthy.
* Hard to read and maintain.

**Solution: Use GenericServlet**

* Implements Servlet, ServletConfig, Serializable.
* Provides default implementation for all methods except `service()`.

```java
public abstract class GenericServlet implements Servlet, ServletConfig, Serializable {
    public void init(ServletConfig config) throws ServletException;
    public void destroy();
    public ServletConfig getServletConfig();
    public String getServletInfo();
    public abstract void service(ServletRequest req, ServletResponse resp);
}
```

> **Design Pattern Used**: Adapter Class Pattern

---

**init() Overloading**

```java
public void init(ServletConfig config) {
    this.config = config;
    init();  // calls overloaded init()
}

public void init() {
    // developer writes initialization logic here
}
```

> Avoid overriding `init(ServletConfig config)`
> Best practice: override `init()` only

---

**Code Example Using GenericServlet**

```java
@WebServlet(urlPatterns="/disp")
public class FourthServlet extends GenericServlet {
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        out.println("<h1 style='color:blue;'>Writing Servlet using GenericServlet is easy....</h1>");
    }
}
```

---

**Behind the Scenes (GenericServlet Flow)**

```
=> Loading:           Loads FourthServlet.class
=> Instantiation:     Creates object
=> Initialization:    Calls init(ServletConfig) → init()
=> RequestProcessing: Calls service()
=> De-Instantiation:  Calls destroy()
```

**Which init method should devs override?** → `init()`

---

**GenericServlet Lifecycle Combinations**

1. No init() in our class:

   * GS: init(SC config)
   * GS: init()
   * US: service()

2. Only init(SC config) in our class:

   * US: init(SC config)
   * US: service()

3. Only init() in our class:

   * GS: init(SC config)
   * US: init()
   * US: service()

```
```

