package com.cloud.plugin.oracle;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @author: OnlyOne
 * @create: 2021-02-06 22:23
 * @description: mybatis-plus代码生成器
 **/
public class MyBatisPlusGenerator {

    public static void main(String[] args) {
        // 1.创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2.全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
//        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setOutputDir("/Users/chenyouhong/Desktop/company/林长制");
        gc.setAuthor("chenyouhong");
        gc.setOpen(true); //生成后是否打开资源管理器
        gc.setFileOverride(false); //重新生成时文件是否覆盖
        /**
         * mp生成service层代码，默认接口名称第一个字母有 I
         *
         */
        gc.setServiceName("%sService");//去掉Service接口的首字母I
        gc.setIdType(IdType.AUTO);//主键策略,IdType.AUTO对应的策略为主键自增
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
//        gc.setSwagger2(true); // 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        //3. 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:oracle:thin:@10.0.0.10:1521:helowin");
        dsc.setDbType(DbType.ORACLE);
        dsc.setTypeConvert(new OracleTypeConvert());
        dsc.setDriverName("oracle.jdbc.driver.OracleDriver");
        dsc.setUsername("FOREST_LEADER");
        dsc.setPassword("FOREST_LEADER");
        mpg.setDataSource(dsc);

        // 4.包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName("fl");
        pc.setParent("com.cloud.fl");
        pc.setController("controller");
        pc.setEntity("model");
        pc.setService("service");
        pc.setMapper("mapper");

        mpg.setPackageInfo(pc);

        // 5.策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude(new String[]{"BS_UNIT", "BS_USERBASE"}); // 表名字，注意一定要大写！大写！否则识别不出来！
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
//        strategy.setTablePrefix(pc.getModuleName() + "_"); //生成实体时去掉表前缀
//        strategy.setTablePrefix(new String[] { "fl_" });// 此处可以修改为您的表前缀
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);;//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true);// lombok 模型 @Accessors(chain true) setter链式操作
        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.setStrategy(strategy);
        mpg.execute();
    }

}