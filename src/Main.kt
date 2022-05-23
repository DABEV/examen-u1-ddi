import CompanionObject
import java.util.*


class Main {

    val sc: Scanner = Scanner(System.`in`);
    var cookingCourses: MutableList<CookingCourse> = mutableListOf()
    var programingCourses: MutableList<ProgramingCourse> = mutableListOf()
    val companionObj: CompanionObject = CompanionObject()
}

fun main(args: Array<String>) {
    var main = Main()
    println("Cursos :D")
    do {
        println("Opciones disponibles")
        println("1 -> Cursos de cocina")
        println("2 -> Cursos de programación")
        println("3 -> Listar Todos")
        println("4 -> Salir :C")
        println("Ingrese una opción")
        var opc: Int = main.sc.nextInt()
        when (opc) {
            1 -> {
                println("\nCursos de cocina")
                do {
                    var course: CookingCourse? = null
                    println("1 -> Add")
                    println("2 -> Update")
                    println("3 -> Delete")
                    println("4 -> Get")
                    println("5 -> Regresar al menú principal :Dd")
                    println("Ingrese una opción:")
                    var opc: Int = main.sc.nextInt()
                    when (opc) {
                        1 -> {
                            course = main.addCookingCourse()
                            if (course != null) {
                                main.cookingCourses.add(course)
                                println("Mensaje de exito")
                            } else println("Mensaje de error")
                        }
                        2 -> {
                            println("Ingresa el nombre del curso que deseas actulizar")
                            course = main.updateCookingCourse(main.sc.next())
                            if (course != null) {
                                main.getOneCookingCourseById(course.id)
                                println("Mensaje de exito")
                            } else println("Mensaje de error")
                        }
                        3 -> {
                            println("Ingresa el id del curso que deseas eliminar")
                            var id = main.removeCookingCourse(main.sc.nextInt())
                        }
                        4 -> {
                            println("Lista de Cursos de Cocina")
                            var Cocina = main.getAllCocina()
                        }

                        else -> println("Opción inexistente :CCC")
                    }
                } while (opc != 5)
            }
            2 -> {
                println("\nCursos de programación")
                do {
                    var course: ProgramingCourse? = null
                    println("1 -> Add")
                    println("2 -> Update")
                    println("3 -> Delete")
                    println("4 -> Get")
                    println("5 -> Regresar al menú principal :D")
                    println("Ingrese una opción:")
                    var opc: Int = main.sc.nextInt()
                    when (opc) {
                        1 -> {
                            course = main.addProgramingCourse()
                            if (course != null) {
                                val index = main.programingCourses.add(course)
                                println("Mensaje de exito")
                            } else println("Mensaje de error")
                        }
                        2 -> {
                            println("Ingresa el nombre del curso que deseas actulizar")
                            course = main.updateProgramingCourse(main.sc.next())
                        }
                        3 -> {
                            println("Ingresa el id del curso que deseas eliminar")
                            var id = main.removeProgramingCourse(main.sc.nextInt())
                        }
                        4 -> {
                            println("Lista de Cursos de Programación")
                            var Programacion = main.getAllProgramacion()

                        }
                        else -> println("Mensaje error")
                    }
                } while (opc != 5)
            }
            3 -> {
                println("Listar todos")
                var lista = main.getAll()

            }
            4 -> println("Bye")
            else -> println("Opción Inexistente")
        }
    } while (opc != 4)
}

