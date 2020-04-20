fun main(){
    val counter : Int = 0
    val cubeList = MutableList(6) { Cube() }
    throwCubes(cubeList,counter)
}

fun throwCubes(cubes: MutableList<Cube>, counter: Int){
    var secondCounter:Int = counter
    secondCounter++

    throwAgain(cubes)
    var secondCubes: MutableList<Cube> = mutableListOf<Cube>()
    println("Enter indexes of cubes you want to lock [1-6](separated by ' '): ")
    val lockedIndexes: List<Int> = readLine()!!.split(' ').map(String::toInt)
    secondCubes = lockCubes(cubes, lockedIndexes)

    if(secondCounter<4) {
        print("Currently unlocked cubes: ")
        for (cube in secondCubes) {
            if (!cube.getLock())
                print("" + cube.getVal() + " ")
        }
        print("\n")
        print("Currently locked cubes: ")
        for (cube in secondCubes) {
            if (cube.getLock())
                print("" + cube.getVal() + " ")
        }
            println("\nThrowing unlocked cubes...\n\n")
            secondCounter++
            throwCubes(secondCubes, secondCounter)
    }
    else {
        print("\n")
        print("Cubes: ")
        for (cube in secondCubes) {
            if (cube.getLock()) {
                cube.setLock(false)
            }
            print("" + cube.getVal() + " ")
        }

        isJamb(secondCubes)
        isPoker(secondCubes)
        isScale(secondCubes)
    }

}

fun throwAgain(cubes: MutableList<Cube>){
    println("Your cubes: ")
    for (cube in cubes) {
        if (!cube.getLock()){
            cube.cubeNumber()
            print("" + cube.getVal() + " ")
        } else print ("LOCKED ")
    }
    print("\n")
}

fun lockCubes(cubes: MutableList<Cube>, lockedIndexes : List<Int>): MutableList<Cube>{
    lockedIndexes.toMutableList()
    for (j in 0 until (lockedIndexes.size)){
        for(i in 0 until (cubes.size) ){
            if(lockedIndexes[j] == i+1){
                if(!cubes[i].getLock()) {
                    cubes[i].setLock(true)
                }
            }
        }
    }
    return cubes
}

fun isJamb(cubes: MutableList<Cube>){
    val distinctCubes = cubes.distinct()
    if(distinctCubes.size == 1)
        println("\n\nJamb! ")
    else println("\n\nSorry, not jamb ")
}

fun isPoker(cubes: MutableList<Cube>){
    var br1:Int = 0
    var br2:Int = 0
    var br3:Int = 0
    var br4:Int = 0
    var br5:Int = 0
    var br6:Int = 0

    for(cube in cubes)
    {
        when(cube.getVal()){
            1 -> br1++
            2 -> br2++
            3 -> br3++
            4 -> br4++
            5 -> br5++
            6 -> br6++
        }
    }
    if(br1==4 || br2==4 || br3 == 4 || br4==4 || br5==4 || br6==4){
        println("\nPoker! ")
    }else println("\nSorry, not poker ")


}

fun isScale(cubes: MutableList<Cube>){
    if(largeScale(cubes)){
        println("\nBig scale! (2-6) ")
    }else if(smallScale(cubes))
        println("\nSmall scale! (1-5) ")
    else println("\nSorry, not scale ")
}


fun smallScale(cubes: MutableList<Cube>):Boolean{
    var br1:Int = 0
    var br2:Int = 0
    var br3:Int = 0
    var br4:Int = 0
    var br5:Int = 0

    for(cube in cubes)
    {
        when(cube.getVal()){
            1 -> br1++
            2 -> br2++
            3 -> br3++
            4 -> br4++
            5 -> br5++
        }
    }
    return br1 > 0 && br2 > 0 && br3 > 0 && br4 > 0 && br5 > 0
}

fun largeScale(cubes: MutableList<Cube>):Boolean{
    var br2:Int = 0
    var br3:Int = 0
    var br4:Int = 0
    var br5:Int = 0
    var br6:Int = 0

    for(cube in cubes)
    {
        when(cube.getVal()){
            2 -> br2++
            3 -> br3++
            4 -> br4++
            5 -> br5++
            6 -> br6++
        }
    }

    return br2 > 0 && br3 > 0 && br4 > 0 && br5 > 0 && br6 > 0
}



