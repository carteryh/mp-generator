/**
 * Copyright (c) 2011-2016, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.cloud.plugin.mysql;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 代码生成器演示
 * </p>
 *
 * @author hubin
 * @since 2016-12-01
 */
public class Generator {

	/**
	 * <p>
	 * MySQL 生成演示
	 * </p>
	 */
	public static void main(String[] args) {
		int result = 1;
		// 自定义需要填充的字段
		List<TableFill> tableFillList = new ArrayList<>();
		tableFillList.add(new TableFill("create_by", FieldFill.INSERT));
		tableFillList.add(new TableFill("update_by", FieldFill.UPDATE));

		String tag = "lz_finecar";
		// String dbUrl = "jdbc:mysql://192.168.2.100:3306/" + tag +
		// "?characterEncoding=utf8";
		// String dbUser = "root";
		// String dbPwd = "admin12345";
		// String[] tables = new String[] { "person_report_info",};

		// tag = "lz_material";
		// String dbUrl = "jdbc:mysql://192.168.2.100:3306/" + tag +
		// "?characterEncoding=utf8";
		// String dbUser = "root";
		// String dbPwd = "admin12345";
		//
		// String[] tables = new String[] { "person_report_info" };
		tag = "gzslyj_share";
		String dbUrl = "jdbc:mysql://10.0.0.10/" + tag + "?characterEncoding=utf8";
//		String dbUrl = "jdbc:oracle:thin:@10.0.0.10:1521:helowin";
		String dbUser = "root";
		String dbPwd = "12345678";
//		String[] tables = new String[] { "t_user", "t_address", "t_contact", "t_duty_area", "t_duty_organization", "t_position", "t_user_position", "t_user_duty_area" };
		String[] tables = new String[] { "t_all_works",
				"t_authorization_new_varieties_forestry",
				"t_basic_information_nature_reserves",
				"t_forest_city_system",
				"t_forest_main_project_achievements",
				"t_forestry_investment",
				"t_gz_forest_chief_information",
				"t_gz_forest_health_care_pilot_base",
				"t_gz_forestry_investigation_planning_institute",
				"t_gz_kuankuoshui_manager_info",
				"t_talents_training_program_forestry_school",
				"t_zhazuo_forest_farm_info" };

		// 代码生成器
		AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
				// 全局配置
				new GlobalConfig()
						// .setOutputDir("../")//输出目录
						.setOutputDir("/Users/carter/Desktop/mybaits-plus/" + tag)// 输出目录
						.setFileOverride(true)// 是否覆盖文件
						.setActiveRecord(false)// 开启 activeRecord 模式
						.setEnableCache(false)// XML 二级缓存
						.setBaseResultMap(true)// XML ResultMap
						.setBaseColumnList(true)// XML columList
						// .setKotlin(true) 是否生成 kotlin 代码
						.setAuthor("chenyouhong")
						// 自定义文件命名，注意 %s 会自动填充表实体属性！
						.setEntityName("%s").setMapperName("%sMapper")//
						.setXmlName("%sMapper")//
						.setServiceName("%sService")//
						.setServiceImplName("%sServiceImpl")//
						.setControllerName("%sController")//
						.setDtoName("%sDTO")
						.setSwagger2(true)
				)//
				.setDataSource(
						// 数据源配置
						new DataSourceConfig().setDbType(DbType.MYSQL)// 数据库类型
								.setTypeConvert(new MySqlTypeConvert() {
									// 自定义数据库表字段类型转换【可选】
									@Override
									public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
										System.out.println("转换类型：" + fieldType);
										if (fieldType.toLowerCase().contains("datetime")) {
											return DbColumnType.DATE;
										}
										if (fieldType.toLowerCase().contains("tinyint(1)")) {
											return DbColumnType.INTEGER;
										}
										return super.processTypeConvert(globalConfig, fieldType);
									}
								})//
//								.setDriverName("com.mysql.jdbc.Driver")//
								.setDriverName("com.mysql.cj.jdbc.Driver")//
								.setUsername(dbUser)//
								.setPassword(dbPwd)//
								.setUrl(dbUrl))
				.setStrategy(
						// 策略配置
						new StrategyConfig()
								// .setCapitalMode(true)// 全局大写命名
								// .setDbColumnUnderline(true)//全局下划线命名
								.setTablePrefix(new String[] { "t_" })// 此处可以修改为您的表前缀
								.setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
								.setInclude(tables) // 需要生成的表

								// .setExclude(new String[]{"test"}) // 排除生成的表
								// 自定义实体父类
								// .setSuperEntityClass("com.baomidou.demo.TestEntity")
								// 自定义实体，公共字段
								// .setSuperEntityColumns(new String[] { "test_id" })
								.setTableFillList(tableFillList)
								// 自定义 mapper 父类
								// .setSuperMapperClass("com.baomidou.demo.TestMapper")
								// 自定义 service 父类
								// .setSuperServiceClass("com.baomidou.demo.TestService")
								// 自定义 service 实现类父类
								// .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
								// 自定义 controller 父类
								// .setSuperControllerClass("com.baomidou.demo.BaseController")
								// 【实体】是否生成字段常量（默认 false）
								// public static final String ID = "test_id";
								// .setEntityColumnConstant(true)
								// 【实体】是否为构建者模型（默认 false）
								// public User setName(String name) {this.name = name;
								// return this;}
								// .setEntityBuilderModel(true)
								// 【实体】是否为lombok模型（默认 false）<a
								// href="https://projectlombok.org/">document</a>
								.setEntityLombokModel(true)
								// Boolean类型字段是否移除is前缀处理
								// .setEntityBooleanColumnRemoveIsPrefix(true)
								.setRestControllerStyle(true)
				// .setControllerMappingHyphenStyle(true)
				).setPackageInfo(
						// 包配置
						new PackageConfig()//
								.setParent("com.cloud")// 自定义包路径
								.setModuleName("gzslyj")//
								.setController("controller")// 这里是控制器包名，默认 web
								.setMapper("mapper")//
								.setEntity("model")//
								.setXml("sqlmaps")//
								.setDto("dto")

				).setTemplate(
						// 关闭默认 xml 生成，调整生成 至 根目录
						new TemplateConfig()
								// 自定义模板配置，模板可以参考源码
								// /mybatis-plus/src/main/resources/template 使用 copy
								// 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
								.setController("/mysql/controller.java")//
								.setEntity("/mysql/entity.java")//
								.setMapper("/mysql/mapper.java")//
								.setXml("/mysql/mapper.xml")//
								.setService("/mysql/service.java")//
								.setServiceImpl("/mysql/serviceImpl.java")//
								.setDto("/mysql/dto.java")//
								.setAddDto("/mysql/adddto.java")//
								.setUpdDto("/mysql/upddto.java")//
								.setPageinDto("/mysql/pagein.java")//
								.setPageoutDto("/mysql/pageout.java"));
		// 执行生成
		if (1 == result) {
			mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		}
		mpg.execute();

		// 打印注入设置，这里演示模板里面怎么获取注入内容【可无】
		// System.err.println(mpg.getCfg().getMap().get("abc"));
	}

}
