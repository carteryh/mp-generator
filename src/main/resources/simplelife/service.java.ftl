package ${package.Service};

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package.Entity}.${entity};
import ${superServiceClassPackage};
<#list table.fields as field>
<#if field.keyFlag>
        <#assign Key = field.propertyName>
</#if>
</#list>
/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:${table.comment!}
 * </p>
 * @author ${author}
 * @date ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} {

}
</#if>
