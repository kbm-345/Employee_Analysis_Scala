class PreProcessingAndAnalysingData {
      def preProcessingData(preData:List[Employee]):List[Employee] = {
        preData.filter(e => e.city.nonEmpty && e.educationLevel.nonEmpty &&
        e.gender.nonEmpty && e.everBench.nonEmpty && e.paymentTier.nonEmpty)
          .map(e => e.copy(joiningYear=math.max(0,e.joiningYear),
            age=Math.max(0,e.age),
            experienceInCurrentDomain=Math.max(0,e.experienceInCurrentDomain)))
      }
      def analysingData(preData:List[Employee]):Unit = {

        // First apply map on age that will make a group of all age and then .sum method make sum of data
        val meanAge = preData.map(_.age).sum.toDouble/preData.length
        val meanExperience = preData.map(_.experienceInCurrentDomain).sum.toDouble/preData.length

        // first need to groupby all the data which lies into different classes and then map total number of values to particular class
        val educationLevelDistribution = preData.groupBy(_.educationLevel).view.mapValues(_.size).toList.sortBy(_._1)
        val genderRation = preData.groupBy(_.gender).view.mapValues(_.size).toList.sortBy(_._1)
        val peopleInYearJoin = preData.groupBy(_.joiningYear).view.mapValues(_.size).toList.sortBy(_._1)
        val peopleInPaymentTier = preData.groupBy(_.paymentTier).view.mapValues(_.size).toList.sortBy(_._1)
        val peopleInCities = preData.groupBy(_.city).view.mapValues(_.size).toList.sortBy(_._1)
        val leftPeople = preData.map(_.leaveOrNotLeave).sum

        // Filtering data by multiple condition by using groupby and map function
        val bangloreBtechemployee = preData.groupBy(e=>e.city.equalsIgnoreCase("Bangalore") && e.educationLevel.equalsIgnoreCase("Bachelors")).view.mapValues(_.size).toList


        println()
        println(s"Mean Age of the employee data is : $meanAge")
        println(s"Average Experience of all the employee : $meanExperience")
        println()
        println(s"Number of people left the company : $leftPeople")
        println()

        // for loop for printing data in some good manner which use S interpolation
        var str=" "
        for(i<- 0 until educationLevelDistribution.length)
        {

          str = s"${educationLevelDistribution(i)._1} --> ${educationLevelDistribution(i)._2} \n "+ str
        }
        println(s"Education level Distribution of all employees : \n $str")


        str=" "
        for(i<- 0 until genderRation.length)
          {

            str = s"${genderRation(i)._1} --> ${genderRation(i)._2} \n "+ str
          }
        println(s"Gender Ration in company : \n $str")


        str=" "
        for(i<- 0 until peopleInYearJoin.length)
        {

          str = s"${peopleInYearJoin(i)._1} --> ${peopleInYearJoin(i)._2} \n "+ str
        }
        println(s"Total employee in years joining : \n $str")

        str=" "
        for(i<- 0 until peopleInPaymentTier.length)
        {

          str = s"${peopleInPaymentTier(i)._1} --> ${peopleInPaymentTier(i)._2} \n "+ str
        }
        println(s"Total number of employee in tier : \n $str")

        str=" "
        for(i<- 0 until peopleInCities.length)
        {

          str = s"${peopleInCities(i)._1} --> ${peopleInCities(i)._2} \n "+ str
        }
        println(s"Total number of employee in tier : \n $str")
        println(s"Number of people who is in Banglore and doing Bachelors : ${bangloreBtechemployee(1)._2}")
        println()
      }
}
