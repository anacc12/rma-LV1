import kotlin.random.Random
import kotlin.test.assertTrue

class Cube() {
    private var value : Int = 0
    private var locked: Boolean = false

    fun cubeNumber(){
        value = Random.nextInt(1, 7)
    }

    fun setLock(locked: Boolean){
        this.locked = locked
    }

    fun getLock():Boolean{
        return locked
    }

    fun setVal(value: Int){
        this.value = value
    }

    fun getVal() : Int{
        return value
    }
}