package zoret4.payme.web.util

import org.mockito.Mockito


class TestsHelper {

    companion object {
        /**
         * https://medium.com/@elye.project/befriending-kotlin-and-mockito-1c2e7b0ef791
         */
        fun <T> any(): T {
            Mockito.any<T>()
            return uninitialized()
        }

        private fun <T> uninitialized(): T = null as T
    }


}