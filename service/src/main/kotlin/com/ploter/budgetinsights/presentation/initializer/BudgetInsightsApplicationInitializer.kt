package com.ploter.budgetinsights.presentation.initializer

import com.ploter.budgetinsights.presentation.configuration.ApplicationConfiguration
import com.ploter.budgetinsights.presentation.configuration.PersistenceConfiguration
import com.ploter.budgetinsights.presentation.configuration.SpringConfiguration
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer

class BudgetInsightsApplicationInitializer : AbstractAnnotationConfigDispatcherServletInitializer() {

    override fun getRootConfigClasses(): Array<Class<*>>? {
        return null //arrayOf(RootConfig::class.java)
    }

    override fun getServletConfigClasses(): Array<Class<*>> {
        // 	If an application context hierarchy is not required,
        // 	applications can return all configuration through getRootConfigClasses() and null from getServletConfigClasses().
        return arrayOf(
                SpringConfiguration::class.java,
                ApplicationConfiguration::class.java,
                PersistenceConfiguration::class.java,
        )
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