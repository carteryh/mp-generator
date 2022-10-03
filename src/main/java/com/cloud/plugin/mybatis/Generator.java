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
package com.cloud.plugin.mybatis;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

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
		String[] tables = new String[] {"advanced_collective_information",
				"afforestation_completion_statistics",
				"afforestation_production_situation",
				"alien_pest_control_area",
				"alien_pest_invaded_area",
				"annual_forest_seedling_production_condition",
				"append_quota_base_data_table",
				"area_of_control_area_and_hierarchical_control_area",
				"basic_data_of_cutting_quota",
				"catalogue_of_standardized_forestry_stations",
				"compensation_fores_ecologica_benefit",
				"deforestation_quotas_annual_cutting_advice",
				"deforestation_quotas_annual_cutting_advice_summary",
				"deforestation_quotas_commercial_forest_area_cumulation",
				"deforestation_quotas_land_category_area_cumulation",
				"deforestation_quotas_public_forest_area",
				"deforestation_quotas_reasonable_annual_cutting",
				"duty_plant_tree",
				"ecological_forest_ranger_allocation_processing",
				"ecological_forest_ranger_responsibility",
				"evaluation_of_forest_ecosystem_service_quality",
				"fire_control_station",
				"fire_emergency_supplies_warehouse",
				"forest_and_other_seed_production_and_operation_license",
				"forest_disease_pest_area",
				"forest_ecological_service_function_of_matter_quality",
				"forest_ecosystem_services",
				"forest_ecosystem_services_value",
				"forest_farm_data_resources",
				"forest_farm_directly_under",
				"forest_health_base",
				"forest_improved_seed_base",
				"forest_insurance_statistic",
				"forest_park",
				"forest_park_data",
				"forest_park_information",
				"forest_seed_collection_base",
				"forest_seed_production_operation_license",
				"forest_superior_species_catalogue",
				"forestry_bureau_initiates_scientific_research_projects",
				"forestry_key_enterprise",
				"forestry_leading_enterprise",
				"forestry_pest_quarantine_information",
				"forestry_production",
				"geological_park",
				"guizhou_bamboo_garden_database",
				"guizhou_control_pests_diseases",
				"guizhou_first_list_of_important_wetlands",
				"guizhou_herbarium_database",
				"guizhou_list_of_vascular_plant_resources",
				"guizhou_monitoring_evaluation_benefit_of_return_forest_project",
				"guizhou_pests_diseases",
				"guizhou_provincial_forestry_protection_nursery",
				"guizhou_rare_plant_database_of_arboretum",
				"guizhou_wetland_park_basic_situation",
				"guizhou_wood_specimen_database",
				"list_of_insects_collected_by_academy_of_forestry",
				"logging_statistics_table",
				"masson_pine_seed_orchards_data",
				"national_forest_germplasm_bank",
				"natural_forest_protection_project_basic_info",
				"natural_reserve_information",
				"nature_reserve_information",
				"normative_document_on_forest_resource_protection",
				"permission_to_handle_useof_woodland_procedures",
				"personnel_distribution_of_ecological_forest_management_area",
				"pest_quarantine_information",
				"preservation_of_forest_germplasm_resources",
				"provincial_cities_and_counties_forest_cutting_statistics",
				"provincial_cities_and_counties_logging_statistics",
				"provincial_forestry_protection_nursery",
				"provincial_township_forestry_workstations_basic_statistics",
				"public_welfare_forest_info",
				"publishing_standard",
				"quarantine_issuance_certificate_management",
				"quota_appended_record",
				"scale_and_scope_of_newly_converted_farmland",
				"science_and_technology_promotion_demonstration_project",
				"state_forest_farm_data_resources",
				"table_of_forest_holding_targets",
				"task_status_of_program_for_converting_farmland_to_forest",
				"technical_practical_and_vocational_forestry_skills_training",
				"tianbao_engineering_task_planning_info",
				"tourist_attraction",
				"treatment_of_stony_desertification",
				"value_of_forest_ecological_service_function",
				"watchtower",
				"water_point",
				"wetland_park",
				"winner_information",
				"workstation_basic_information",
				"yunguanshan_provincial_forest_park_data"
		};

		// 代码生成器
		AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
				// 全局配置
				new GlobalConfig()
						// .setOutputDir("../")//输出目录
						.setOutputDir("D:\\code\\" + tag)// 输出目录
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
// 								.setDriverName("oracle.jdbc.driver.OracleDriver")
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
				// .setControllerMappingHyphenStyle(true) com.cloud.user.model
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
								.setController("/templete/controller.java")//
								.setEntity("/templete/entity.java")//
								.setMapper("/templete/mapper.java")//
								.setXml("/templete/mapper.xml")//
								.setService("/templete/service.java")//
								.setServiceImpl("/templete/serviceImpl.java")//
								.setDto("/templete/dto.java")//
								.setAddDto("/templete/adddto.java")//
								.setUpdDto("/templete/upddto.java")//
								.setPageinDto("/templete/pagein.java")//
								.setPageoutDto("/templete/pageout.java"));
		// 执行生成
		if (1 == result) {
			mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		}
		mpg.execute();

		// 打印注入设置，这里演示模板里面怎么获取注入内容【可无】
		// System.err.println(mpg.getCfg().getMap().get("abc"));
	}

}
