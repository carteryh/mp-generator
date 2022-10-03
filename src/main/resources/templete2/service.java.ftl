package ${package.Service};

import java.util.List;
import java.util.Map;

import ${package.Entity}.${entity};
import ${package.Dto}.${entity}PageIn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param saleArea
	 */
	${entity} findById(Long ${Key});

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param ${entity?uncap_first}
	 */
	void insertObj(${entity} ${entity?uncap_first}) throws Exception;

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param ${entity?uncap_first}
	 */
	void deleteObj(${entity} ${entity?uncap_first}) throws Exception;

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param ${entity?uncap_first}
	 */
	void updateObj(${entity} ${entity?uncap_first}) throws Exception;

	
	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param pageIn
	 * @param pageRequest
	 * @return
	 * @throws Exception
	 */
	Page selectMyPage(${entity}PageIn pageIn, PageRequest pageRequest) throws Exception;
}
</#if>
