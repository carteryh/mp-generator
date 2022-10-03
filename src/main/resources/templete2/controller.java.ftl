package ${package.Controller};

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ${package.Dto}.${entity}AddDTO;
import ${package.Dto}.${entity}UpdDTO;
import ${package.Dto}.${entity}PageIn;
import ${package.Dto}.${entity}PageOut;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import com.lz.utils.BeanCloneUtils;
import com.lz.utils.ResponseMsg;

import io.swagger.annotations.ApiOperation;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:${table.comment!} 业务请求
 * </p>
 * @author ${author}
 * @date ${date}
 */
<#list table.fields as field>
<#if field.keyFlag>
       <#assign Key = field.propertyName>
</#if>
</#list>
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("/${table.entityPath?lower_case}")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

	@Autowired
	private ${table.serviceName} ${table.serviceName?uncap_first};

	@GetMapping("/{${Key}}")
	@ApiOperation(value = "通过${Key}获取")
	public ResponseMsg info(@PathVariable(name = "${Key}", required = true) Long ${Key})  {
		${entity} ${entity?uncap_first} = ${table.serviceName?uncap_first}.findById(${Key});
		return ResponseMsg.success(${entity?uncap_first});
	}

	@PostMapping("/page")
	@ApiOperation(value = "分页")
	public ResponseMsg page(@RequestBody ${entity}PageIn pageIn) throws Exception{
		// 分页排序 排序 不去设置在 PageRequest
		PageRequest pageRequest = PageRequest.of(pageIn.getPage(), pageIn.getSize());
		Page page = ${table.serviceName?uncap_first}.selectMyPage(pageIn, pageRequest);
		MyPage mypage = BeanCloneUtils.copyTo(page, MyPage.class);
		List<${entity}PageOut> list = BeanCloneUtils.copyTo(mypage.getContent(), ${entity}PageOut.class);
		mypage.setContent(list);
		return ResponseMsg.success(mypage);
	}

	@PostMapping
	@ApiOperation(value = "添加")
	public ResponseMsg add(@RequestBody @Valid ${entity}AddDTO dto, BindingResult bindingResult) throws Exception{
		${entity} add = BeanCloneUtils.copyTo(dto, ${entity}.class);
		${table.serviceName?uncap_first}.insertObj(add);
		return ResponseMsg.success("ok");
	}

	@PutMapping
	@ApiOperation(value = "修改")
	public ResponseMsg upd(@RequestBody @Valid ${entity}UpdDTO dto, BindingResult bindingResult) throws Exception{
		${entity} modify = BeanCloneUtils.copyTo(dto, ${entity}.class);
		${table.serviceName?uncap_first}.updateObj(modify);
		return ResponseMsg.success("ok");
	}

	@DeleteMapping("/{${Key}}")
	@ApiOperation(value = "删除")
	public ResponseMsg del(@PathVariable(name = "${Key}", required = true) Long ${Key}) throws Exception{
		${entity} del = new ${entity}();
		del.set${Key?cap_first}(${Key});
		${table.serviceName?uncap_first}.deleteObj(del);
		return ResponseMsg.success("ok");
	}

}
</#if>
