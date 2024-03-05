import scala.io.Source
class ParseEmployeeData {
  def loadDataFromCsv(filePath:String) : List[Employee] = {

    // read CSV file using Source library
    val lines = Source.fromFile(filePath).getLines().toList.tail

    // this function maps the details to object and create Employee object
    lines.map(makeObjectFromCsv)
  }
  def makeObjectFromCsv(row:String):Employee = {
    val data = row.split(",").map(_.trim)
    Employee(
      data(0),
      data(1).toInt,
      data(2),
      data(3),
      data(4).toInt,
      data(5),
      data(6),
      data(7).toInt,
      data(8).toInt
    )
  }
}
