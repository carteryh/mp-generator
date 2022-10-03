package ${package.ServiceImpl};

import java.util.List;
import java.util.Map;

import ${package.Entity}.${entity};
import ${package.Dto}.${entity}PageIn;
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import com.springplugin.arroundlog.annonation.ServiceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} implements ${table.serviceName} {

	@Autowired
	${entity}Repository ${entity?uncap_first}Repository;
	
	@Override
	@ServiceLog(description = "通过ID查找对象")
	public ${entity} findById(Long ${Key?uncap_first}) {
		return ${entity?uncap_first}Repository.getOne(${Key?uncap_first});
	}

	@Override
	@ServiceLog(description = "插入对象")
	@Transactional(rollbackFor = Exception.class)
	public void insertObj(${entity} ${entity?uncap_first}) {
		${entity?uncap_first}Repository.save(${entity?uncap_first});
	}

	@Override
	@ServiceLog(description = "更新对象")
	@Transactional(rollbackFor = Exception.class)
	public void updateObj(${entity} ${entity?uncap_first}) throws Exception {
		${entity?uncap_first}Repository.save(${entity?uncap_first});

	}

	@Override
	@ServiceLog(description = "删除对象")
	@Transactional(rollbackFor = Exception.class)
	public void deleteObj(${entity} ${entity?uncap_first}) throws Exception {
		${entity?uncap_first}Repository.save(${entity?uncap_first});
	}

	@Override
	@ServiceLog(description = "分页")
	public Page selectMyPage(${entity}PageIn pageIn, PageRequest pageRequest) throws Exception {
		return ${entity?uncap_first}Repository.queryAll(pageIn, pageRequest);
	}

}
</#if>
