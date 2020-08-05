<?xml version="1.0"?>
<recipe>
    <instantiate from="root/src/app_package/ViewModel.kt.ftl"
      to="${moduleName}/src/main/java/${slashedPackageName(packageName)}/${className}.kt" />
    <instantiate from="root/test/app_package/ViewModelTest.kt.ftl"
      to="${moduleName}/src/test/java/${slashedPackageName(packageName)}/${className}Test.kt" />

    <open file="${moduleName}/src/main/java/${slashedPackageName(packageName)}/${className}.kt"/>

    <#if includeViewModelFactory>
        <instantiate from="root/src/app_package/ViewModelFactory.kt.ftl"
          to="${moduleName}/src/main/java/${slashedPackageName(packageName)}/${className}Factory.kt" />

        <open file="${moduleName}/src/main/java/${slashedPackageName(packageName)}/${className}Factory.kt" />
    </#if>
</recipe>
