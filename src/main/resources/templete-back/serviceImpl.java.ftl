package ${package.ServiceImpl};

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springplugin.arroundlog.annonation.ServiceLog;

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
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

	@Autowired
	${entity}Dao ${entity?uncap_first}Dao;
	
	@Override
	@ServiceLog(description = "通过ID查找对象")
	public ${entity} findById(Long ${Key?uncap_first}) {
		return ${entity?uncap_first}Dao.selectById(${Key?uncap_first});
	}

	@Override
	@ServiceLog(description = "插入对象")
	@Transactional(rollbackFor = Exception.class)
	public void insertObj(${entity} ${entity?uncap_first}) {
		${entity?uncap_first}Dao.insert(${entity?uncap_first});
	}

	@Override
	@ServiceLog(description = "更新对象")
	@Transactional(rollbackFor = Exception.class)
	public void updateObj(${entity} ${entity?uncap_first}) {
		${entity?uncap_first}Dao.updateById(${entity?uncap_first});

	}

	@Override
	@ServiceLog(description = "删除对象")
	@Transactional(rollbackFor = Exception.class)
	public void deleteObj(${entity} ${entity?uncap_first}) {
		${entity?uncap_first}Dao.updateById(${entity?uncap_first});
	}

	@Override
	@ServiceLog(description = "通过对象查找一个结果")
	public ${entity} findOneByObj(${entity} ${entity?uncap_first}) {
		QueryWrapper<${entity}> qw = new QueryWrapper<${entity}>(${entity?uncap_first});
		return ${entity?uncap_first}Dao.selectOne(qw);
	}

	@Override
	@ServiceLog(description = "通过对象查找列表")
	public List<${entity}> findByObj(${entity} ${entity?uncap_first}) {
		QueryWrapper<${entity}> qw = new QueryWrapper<${entity}>(${entity?uncap_first});
		return ${entity?uncap_first}Dao.selectList(qw);
	}

	@Override
	@ServiceLog(description = "分页")
	public Page selectMyPage(Page page, Map<String, Object> params) {
		return ${entity?uncap_first}Dao.selectMyPage(page, params);
	}

}
</#if>
