## Fragment生命周期调试

当 MyFragment1 被添加到屏幕上时，会依次执行：<br>
onAttach--->onCreate--->onCreateView--->onViewCreated--->onActivityCreated--->onStart--->onResume
<br>

当替换为 MyFragment2 时，如果使用 addToBackStack 时，会依次执行：<br>
onPause--->onStop--->onDestroyView
<br>

当点击 Back 键时，会依次执行：<br>
onCreateView--->onViewCreated--->onActivityCreated--->onStart--->onResume
<br>

当再次点击 Back 键时，会依次执行：<br>
onPause--->onStop--->onDestroyView--->onDestroy--->onDetach
<br>

如果执行没有使用 addToBackStack 时，会直接执行：onDestroy--->onDetach
