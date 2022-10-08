fun main(args: Array<String>) {

    var date = listOf<Int>()
    var month = listOf<Int>()
    var year = listOf<Int>()

    dates(
        day = 3,
        month = 1,
        year = 2022,
        day_ = {
            date = it
        },
        month_ = {
            month = it
        },
        year_ = {
            year = it
        }
    )

    println(date)
    println(month)
    println(year)

}

fun dates(
    day: Int,
    month: Int,
    year: Int,
    day_: (List<Int>) -> Unit,
    month_: (List<Int>) -> Unit,
    year_: (List<Int>) -> Unit,
) {
    var days = day+1
    var months = month
    var years = year

    val dates = arrayListOf<Int>()
    val mMonth = arrayListOf<Int>()
    val mYear = arrayListOf<Int>()

    for (i in 1..8) {
        if (days!=1) {
            days -= 1
            dates.add(days)
            mMonth.add(months)
            mYear.add(years)
        } else {
            months -=1
            if (months==0) {
                years -=1
            }
            mMonth.add(
                if (months==0) {
                    months = 12; 12
                } else months
            )
            mYear.add(years)
            days = monthLastDate(month = months, year = years)+1
            dates.add(days)
        }
    }

    mMonth.removeLast()
    mYear.removeLast()

    day_(dates)
    month_(mMonth)
    year_(mYear)

}

fun monthLastDate(
    month: Int,
    year: Int
): Int {
    return when (month) {
        1 -> 31
        2 ->
            if (year%4==0) {
                if (year%100==0 && year % 400 !=0) {
                    28
                } else 29
            } else 28
        3 -> 31
        4 -> 30
        5 -> 31
        6 -> 30
        7 -> 31
        8 -> 31
        9 -> 30
        10 -> 31
        11 -> 30
        12 -> 31
        else -> 31
    }
}



















