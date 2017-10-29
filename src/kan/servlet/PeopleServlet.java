package kan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kan.entity.People;
import kan.service.PeopleService;
import kan.service.impl.PeopleServiceImpl;

/**
 * 员工servlet 实现页面的增删查改功能
 */
@WebServlet("/PeopleServlet")
public class PeopleServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	public static final String QUERY_All="queryAll";
	public static final String INSERT="insert";
	public static final String UPDARE="update";
	public static final String DELETE="delete";
	public static final String QUERY_BY_ID="queryById";
	public static final String TO_ADD="toAdd";
	
	private PeopleService peopleService;

	/**
	 * 接受get请求,根据页面的参数返回页面结果
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //设置编码及返回格式
	    request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        
        //页面的参数返回页面结果
		String type=request.getParameter("type");
		PrintWriter out = response.getWriter();
		String pageString="";
        switch (type) {
        case INSERT:
            pageString = doInsert(request, response);
            break;
        case UPDARE:
            pageString = doUpdate(request, response);
            break;
        case DELETE:
            pageString = doDeleteById(request, response);
            break;
        case QUERY_BY_ID:
            pageString = doQueryById(request, response);
            break;
        case TO_ADD:
            pageString = toAdd(request, response);
            break;
        default:
            pageString = doQueryAll(request, response);
            break;
        }
		out.println(pageString);
		out.flush();
	}
	
	private String toAdd(HttpServletRequest request,
            HttpServletResponse response) {
	    String pageString="";
	    pageString+="<html lang='en'><head><meta charset='UTF-8'><title>新增用户</title></head> <body><div align='center' style='width: 400px; position: relative;left:450px'>"+
	    "<form action='${url}/zhu/Servlet_TbUser?who=Insert' method='post'>"+
	    "<h4>新增用户</h4> 姓名: <input type='text' name='name'><br /> <br /> 年龄: <input type='text' name='age'><br /> <br /><input type='submit' value='提交'/>  <input type='reset' value='重置'/>"+
	    "</form></div>  </body></html>";
        return pageString;
    }

    public String doQueryAll(HttpServletRequest request, HttpServletResponse response) {
       List<People> pList=peopleService.queryAllData(); 
       
       String pageString="";
       if(pList!=null&&pList.size()>0){
           pageString+="<html lang='en'><head><meta charset='UTF-8'><title>查询页面</title></head>"+
                   " <body><div align='center'style='width: 400px; position: relative;left:450px;'>"+
                   "<form action='ListPeople' ><table border='1' cellspacing='0'> <tr><th>编号</th>"+
                   "<th>姓名</th><th>年龄</th><th>操作</th> </tr>";
       }
       for( int i = 0 ; i < pList.size()-1 ; i++) {
           People people=pList.get(i);
           pageString+=" <tr><td>"+people.getId()+"</td><td>"+people.getName()+"</td><td>"+people.getAge()+"</td></tr>";
       }
       pageString+= " </table><div > <a href= '/PersonnelResourceSystem/PeopleServlet?type=toAdd'   style='text-decoration:none'>新增</a>  </div></form></div></body></html>";
        return pageString;
    }
	
	private String doQueryById(HttpServletRequest request,
            HttpServletResponse response) {
        // TODO Auto-generated method stub
        return null;
    }

    public String doUpdate(HttpServletRequest request,
            HttpServletResponse response) {
        // TODO Auto-generated method stub
        return null;
    }

	public String doInsert(HttpServletRequest request,
            HttpServletResponse response) {
        
	    
	    
	    
	    
	    
        return null;
    }

	
	public String doDeleteById(HttpServletRequest request,
            HttpServletResponse response) {
        // TODO Auto-generated method stub
        return null;
    }


	public PeopleServlet() {
	    peopleService=new PeopleServiceImpl();
    }

	

}
