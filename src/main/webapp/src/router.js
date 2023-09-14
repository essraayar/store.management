import {createRouter,createWebHistory} from 'vue-router';
import SearchForm from "@/components/SearchForm.vue";
import CreateStoreForm from "@/components/CreateStoreForm.vue";


const routes=[
        {
            path: '/search',
            name: 'SearchForm',
            component: SearchForm
        },
        {
            path:'/create',
            name: 'CreateStoreForm',
            component:CreateStoreForm
        }
    ];
const router = createRouter({
    history:createWebHistory(),
    routes
});

export default router;
