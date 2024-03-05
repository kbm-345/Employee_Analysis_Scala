import scala.io.Source
object Main {
  def main(args: Array[String]): Unit = {
    val path = "C:/Users/c22755b/IdeaProjects/Employee_Analysis/src/main/scala/Employee.csv"
    val AllEmployeeDetailsObject = new ParseEmployeeData
    val AllEmployeeDetails = AllEmployeeDetailsObject.loadDataFromCsv(path)
    val employeeAnalysis = new PreProcessingAndAnalysingData
    employeeAnalysis.preProcessingData(AllEmployeeDetails)
    employeeAnalysis.analysingData(AllEmployeeDetails)
    println()
  }
}