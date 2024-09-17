const base = {
    get() {
        return {
            url : "http://localhost:8080/gongzuoliuchengguanli/",
            name: "gongzuoliuchengguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/gongzuoliuchengguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "工作流程管理系统"
        } 
    }
}
export default base
