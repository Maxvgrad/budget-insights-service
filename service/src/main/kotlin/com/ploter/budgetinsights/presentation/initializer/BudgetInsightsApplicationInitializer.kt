package com.ploter.budgetinsights.presentation.initializer;

import com.ploter.budgetinsights.presentation.configuration.SpringConfiguration
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer

import javax.servlet.ServletContext;

class BudgetInsightsApplicationInitializer : AbstractAnnotationConfigDispatcherServletInitializer() {

    override fun getRootConfigClasses(): Array<Class<*>>? {
        return null //arrayOf(RootConfig::class.java)
    }

    override fun getServletConfigClasses(): Array<Class<*>> {
        return arrayOf(SpringConfiguration::class.java) // 	If an application context hierarchy is not required, applications can return all configuration through getRootConfigClasses() and null from getServletConfigClasses().
    }

    override fun getServletMappings(): Array<String> {
        return arrayOf("/")
    }

//    override fun getServletFilters(): Array<Filter> {
//        return arrayOf(HiddenHttpMethodFilter(), CharacterEncodingFilter())
//    }


    //    override fun onStartup(container: ServletContext) {
//        val appContext = XmlWebApplicationContext()
//        appContext.setConfigLocation("classpath:/WEB-INF/web.xml")
//
//        val registration = container.addServlet("dispatcher", DispatcherServlet(appContext))
//        registration.setLoadOnStartup(1)
//        registration.addMapping("/")
//    }
}